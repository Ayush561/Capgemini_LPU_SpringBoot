package com.yourorg.library.LibraryAssignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Author;
import com.yourorg.library.LibraryAssignment.Entites.Book;
import com.yourorg.library.LibraryAssignment.Entites.Category;
import com.yourorg.library.LibraryAssignment.Entites.LibraryBranch;
import com.yourorg.library.LibraryAssignment.Exception.ResourceNotFoundException;
import com.yourorg.library.LibraryAssignment.Repositories.AuthorRepository;
import com.yourorg.library.LibraryAssignment.Repositories.BookRepository;
import com.yourorg.library.LibraryAssignment.Repositories.CategoryRepository;
import com.yourorg.library.LibraryAssignment.Repositories.LibraryBranchRepository;


@Service
public class BookService {

    @Autowired private BookRepository bookRepo;
    @Autowired private CategoryRepository categoryRepo;
    @Autowired private LibraryBranchRepository branchRepo;
    @Autowired private AuthorRepository authorRepo;

    public Book addBook(Book book, Long categoryId, Long branchId, Set<Long> authorIds) {

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        LibraryBranch branch = branchRepo.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));

        Set<Author> authors = new HashSet<>(authorRepo.findAllById(authorIds));

        book.setCategory(category);
        book.setBranch(branch);
        book.setAuthors(authors);
        book.setCopiesAvailable(book.getCopiesTotal());
        book.setStatus("ACTIVE");

        return bookRepo.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book updateBook(Long id, Book updated) {

        Book book = getBookById(id);

        if (updated.getTitle() != null)
            book.setTitle(updated.getTitle());

        if (updated.getCopiesTotal() > 0)
            book.setCopiesTotal(updated.getCopiesTotal());

        return bookRepo.save(book);
    }

    public void disableBook(Long id) {
        Book book = getBookById(id);
        book.setStatus("INACTIVE");
        bookRepo.save(book);
    }
}