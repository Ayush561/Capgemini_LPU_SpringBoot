package com.yourorg.library.LibraryAssignment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.LibraryBranch;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {
	
}

