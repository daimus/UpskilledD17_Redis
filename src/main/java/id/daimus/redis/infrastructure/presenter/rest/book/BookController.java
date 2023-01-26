package id.daimus.redis.infrastructure.presenter.rest.book;

import id.daimus.redis.application.book.entity.Book;
import id.daimus.redis.application.book.service.BookService;
import id.daimus.redis.infrastructure.presenter.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.LockSupport;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Object> getBooks(){
        log.info("GET /books/{id} called");
        Response response = new Response();
        List<Book> books = bookService.getBooks();
        response.setData(books);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getBook(@PathVariable Long id){
        log.info("GET /books/{id} called");
        Response response = new Response();
        Book book = bookService.getBook(id);
        response.setData(book);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book book){
        log.info("GET /books/{id} called");
        Response response = new Response();
        book = bookService.saveBook(book);
        response.setData(book);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Book book){
        log.info("GET /books/{id} called");
        Response response = new Response();
        book = bookService.saveBook(id, book);
        response.setData(book);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        log.info("GET /books/{id} called");
        Response response = new Response();
        bookService.deleteBook(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
