package com.employee.EmployeeAssignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.EmployeeAssignment.Entity.Employee;
import com.employee.EmployeeAssignment.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(201).body(service.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/department/{name}")
    public ResponseEntity<List<Employee>> byDepartment(@PathVariable String name) {
        return ResponseEntity.ok(service.getByDepartment(name));
    }

    @GetMapping("/highsalary")
    public ResponseEntity<List<Employee>> highSalary(@RequestParam double salary) {
        return ResponseEntity.ok(service.getHighSalary(salary));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.countEmployees());
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> sort(@RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok(service.sortBySalary(direction));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> paginate(@RequestParam int page,@RequestParam int size) {
        return ResponseEntity.ok(service.paginate(page, size));
    }

    @GetMapping("/above-average")
    public ResponseEntity<List<Employee>> aboveAverage() {
        return ResponseEntity.ok(service.aboveAverageSalary());
    }
}