package com.yourorg.library.LibraryAssignment.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String issueDate;
    private String dueDate;
    private String returnDate;
    private String loanStatus;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Loan(Long loanId, String issueDate, String dueDate, String returnDate, String loanStatus, Member member,Book book) {
		this.loanId = loanId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.loanStatus = loanStatus;
		this.member = member;
		this.book = book;
	}
	
	public Loan() {
		
	}

	@Override
	public String toString() {
		return "loanId=" + loanId + ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", loanStatus=" + loanStatus + ", member=" + member + ", book=" + book;
	}
	
	

    
}