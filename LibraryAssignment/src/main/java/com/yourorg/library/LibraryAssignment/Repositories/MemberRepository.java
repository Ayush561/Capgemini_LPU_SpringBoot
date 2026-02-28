package com.yourorg.library.LibraryAssignment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
}