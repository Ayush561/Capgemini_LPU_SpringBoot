package com.yourorg.library.LibraryAssignment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}