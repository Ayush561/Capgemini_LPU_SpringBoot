package com.yourorg.library.LibraryAssignment.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Book;
import com.yourorg.library.LibraryAssignment.Service.BookService;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired private BookService service;

    @PostMapping
    public Book add(@RequestBody Book book,@RequestParam Long categoryId,@RequestParam Long branchId,@RequestParam Set<Long> authorIds) {
        return service.addBook(book, categoryId, branchId, authorIds);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book updated) {
        return service.updateBook(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.disableBook(id);
    }
}