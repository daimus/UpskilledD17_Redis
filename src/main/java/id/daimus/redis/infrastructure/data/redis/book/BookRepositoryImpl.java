package id.daimus.redis.infrastructure.data.redis.book;

import id.daimus.redis.application.book.entity.Book;
import id.daimus.redis.application.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final RedisBookRepository redisBookRepository;
    @Override
    public List<Book> findAll() {
        List<BookEntity> bookEntities = (List<BookEntity>) redisBookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity: bookEntities){
            Book book = new Book();
            BeanUtils.copyProperties(bookEntity, book);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book findById(String id) {
        Optional<BookEntity> bookEntity = redisBookRepository.findById(id);
        if (bookEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookEntity.get(), book);
        return book;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(book, bookEntity);
        bookEntity = redisBookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, book);
        return book;
    }

    @Override
    public boolean deleteById(String id) {
        redisBookRepository.deleteById(id);
        return true;
    }
}
