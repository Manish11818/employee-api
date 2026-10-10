package com.example.employee.service;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class EmployeeService {
 private final Map<Long,Employee> employees = new ConcurrentHashMap<>();
 private final AtomicLong sequence = new AtomicLong();
 public List<Employee> all() { return employees.values().stream().sorted(Comparator.comparing(Employee::id)).toList(); }
 public Optional<Employee> find(Long id) { return Optional.ofNullable(employees.get(id)); }
 public Employee create(Employee input) { long id=sequence.incrementAndGet(); Employee saved=new Employee(id,input.name(),input.department()); employees.put(id,saved); return saved; }
 public Optional<Employee> delete(Long id) { return Optional.ofNullable(employees.remove(id)); }
}
