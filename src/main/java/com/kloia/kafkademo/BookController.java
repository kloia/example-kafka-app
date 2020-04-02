package com.kloia.kafkademo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookService bookService;
    private BookRepository repository;

    public BookController(BookService bookService, BookRepository repository) {
        this.bookService = bookService;
        this.repository = repository;
    }

    @GetMapping("/sendBook")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendBook(@RequestParam("book") String name) {
        repository.findByName(name).forEach(bookService::sendBook);
    }
    @GetMapping("/addBook")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addBook(@RequestParam("book") String name) {
        bookService.addBook(name);
    }
}
