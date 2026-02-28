package com.yourorg.library.LibraryAssignment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
	
}
