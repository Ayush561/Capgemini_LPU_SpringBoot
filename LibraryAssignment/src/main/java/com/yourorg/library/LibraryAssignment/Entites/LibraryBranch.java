package com.yourorg.library.LibraryAssignment.Entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String name;
    private String location;
    private String contactNumber;

    @OneToMany(mappedBy = "branch")
    private List<Book> books;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public LibraryBranch(Long branchId, String name, String location, String contactNumber, List<Book> books) {
		this.branchId = branchId;
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
		this.books = books;
	}

	@Override
	public String toString() {
		return "branchId=" + branchId + ", name=" + name + ", location=" + location + ", contactNumber="
				+ contactNumber + ", books=" + books;
	}

    
}