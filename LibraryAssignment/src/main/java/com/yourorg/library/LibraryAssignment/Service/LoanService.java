package com.yourorg.library.LibraryAssignment.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Book;
import com.yourorg.library.LibraryAssignment.Entites.Loan;
import com.yourorg.library.LibraryAssignment.Entites.Member;
import com.yourorg.library.LibraryAssignment.Exception.InvalidOperationException;
import com.yourorg.library.LibraryAssignment.Exception.ResourceNotFoundException;
import com.yourorg.library.LibraryAssignment.Repositories.BookRepository;
import com.yourorg.library.LibraryAssignment.Repositories.LoanRepository;
import com.yourorg.library.LibraryAssignment.Repositories.MemberRepository;


@Service
public class LoanService {

    @Autowired private LoanRepository loanRepo;
    @Autowired private MemberRepository memberRepo;
    @Autowired private BookRepository bookRepo;

    public Loan issueBook(Long memberId, Long bookId, String dueDate) {

        Member member = memberRepo.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        Book book = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (book.getCopiesAvailable() <= 0)
            throw new InvalidOperationException("No copies available");

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);

        Loan loan = new Loan();
        loan.setMember(member);
        loan.setBook(book);
        loan.setIssueDate(java.time.LocalDate.now().toString());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");

        return loanRepo.save(loan);
    }

    public Loan returnBook(Long loanId) {

        Loan loan = loanRepo.findById(loanId).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setReturnDate(java.time.LocalDate.now().toString());
        loan.setLoanStatus("RETURNED");

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);

        return loanRepo.save(loan);
    }

    public Loan getLoanById(Long id) {
        return loanRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepo.findByMemberMemberId(memberId);
    }
}