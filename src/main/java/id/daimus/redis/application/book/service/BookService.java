package id.daimus.redis.application.book.service;

import id.daimus.redis.application.book.entity.Book;
import id.daimus.redis.application.book.repository.BookRepository;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
    public Book getBook(Long id){
        return bookRepository.findById(id);
    }
    public Book saveBook(Long id, @Valid Book book){
        book.setId(id);
        return bookRepository.save(book);
    }
    public Book saveBook(@Valid Book book){
        return bookRepository.save(book);
    }
    public boolean deleteBook(Long id){
        return bookRepository.deleteById(id);
    }
}
