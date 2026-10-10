package com.example.employee.controller;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
 private final EmployeeService service;
 public EmployeeController(EmployeeService service) { this.service=service; }
 @GetMapping public List<Employee> all() { return service.all(); }
 @GetMapping("/{id}") public ResponseEntity<Employee> one(@PathVariable Long id) { return service.find(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); }
 @PostMapping public ResponseEntity<Employee> create(@RequestBody Employee employee) { return ResponseEntity.status(HttpStatus.CREATED).body(service.create(employee)); }
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { return service.delete(id).isPresent()?ResponseEntity.noContent().build():ResponseEntity.notFound().build(); }
}
