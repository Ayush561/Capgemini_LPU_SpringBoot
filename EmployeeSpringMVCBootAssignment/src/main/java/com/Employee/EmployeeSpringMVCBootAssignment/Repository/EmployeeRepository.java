package com.Employee.EmployeeSpringMVCBootAssignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Employee.EmployeeSpringMVCBootAssignment.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	public Employee findByEmailAndPassword(String email,String password);
	
	

}
