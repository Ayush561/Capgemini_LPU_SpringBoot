package com.yourorg.library.LibraryAssignment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
	
}
