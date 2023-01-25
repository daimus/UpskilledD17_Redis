package id.daimus.redis.application.book.repository;

import id.daimus.redis.application.book.entity.Book;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface BookRepository {
    List<Book> findAll();
    Book findById(String id);
    Book save(@Valid Book book);
    boolean deleteById(String id);
}
