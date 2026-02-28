package com.yourorg.library.LibraryAssignment.Entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String email;
    private String phone;
    private String status;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public Member(Long memberId, String name, String email, String phone, String status, List<Loan> loans) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "memberId=" + memberId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", status="+ status + ", loans=" + loans;
	}
	
	

    
}
