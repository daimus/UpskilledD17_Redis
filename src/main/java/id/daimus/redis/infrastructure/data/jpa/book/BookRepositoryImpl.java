package id.daimus.redis.infrastructure.data.jpa.book;

import id.daimus.redis.application.book.entity.Book;
import id.daimus.redis.application.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final JpaBookRepository jpaBookRepository;
    @Override
    @Cacheable(value = "BooksCache")
    public List<Book> findAll() {
        List<BookEntity> bookEntities = (List<BookEntity>) jpaBookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity: bookEntities){
            Book book = new Book();
            BeanUtils.copyProperties(bookEntity, book);
            books.add(book);
        }
        return books;
    }

    @Override
    @CacheEvict(cacheNames = "BooksCache", allEntries = true)
    @CachePut(key = "#book.id", value = "BooksCache")
    public Book save(Book book) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(book, bookEntity);
        bookEntity = jpaBookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, book);
        return book;
    }

    @Override
    @Cacheable(key = "#id" ,value = "BooksCache")
    public Book findById(Long id) {
        Optional<BookEntity> bookEntity = jpaBookRepository.findById(id);
        if (bookEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookEntity.get(), book);
        return book;
    }

    @Override
    @CacheEvict(cacheNames = "BooksCache", allEntries = true)
    public boolean deleteById(Long id) {
        jpaBookRepository.deleteById(id);
        return true;
    }
}
