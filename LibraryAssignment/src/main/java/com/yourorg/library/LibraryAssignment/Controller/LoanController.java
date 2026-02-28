package com.yourorg.library.LibraryAssignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Loan;
import com.yourorg.library.LibraryAssignment.Service.*;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired private LoanService service;

    @PostMapping("/issue")
    public Loan issue(@RequestParam Long memberId,@RequestParam Long bookId,@RequestParam String dueDate) {

        return service.issueBook(memberId, bookId, dueDate);
    }

    @PutMapping("/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId) {
        return service.returnBook(loanId);
    }

    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable Long loanId) {
        return service.getLoanById(loanId);
    }

    @GetMapping
    public List<Loan> getAll() {
        return service.getAllLoans();
    }

    @GetMapping("/member/{memberId}")
    public List<Loan> getByMember(@PathVariable Long memberId) {
        return service.getLoansByMember(memberId);
    }
}