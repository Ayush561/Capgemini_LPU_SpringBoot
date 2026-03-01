package com.employee.EmployeeAssignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.employee.EmployeeAssignment.Entity.Employee;
import com.employee.EmployeeAssignment.Exception.EmployeeNotFoundException;
import com.employee.EmployeeAssignment.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setDepartment(updatedEmployee.getDepartment());
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }

    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public List<Employee> getHighSalary(double salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    public long countEmployees() {
        return repository.count();
    }

    public List<Employee> sortBySalary(String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by("salary").descending() :
                Sort.by("salary").ascending();
        return repository.findAll(sort);
    }

    public Page<Employee> paginate(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public List<Employee> aboveAverageSalary() {
        return repository.findEmployeesAboveAverageSalary();
    }
}