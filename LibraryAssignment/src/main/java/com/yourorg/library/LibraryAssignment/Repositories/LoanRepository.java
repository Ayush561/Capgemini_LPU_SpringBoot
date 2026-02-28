package com.yourorg.library.LibraryAssignment.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourorg.library.LibraryAssignment.Entites.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberMemberId(Long memberId);
}