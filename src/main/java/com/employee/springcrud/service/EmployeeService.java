package com.employee.springcrud.service;

import com.employee.springcrud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee saveEmployee(Employee emp);
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long  id);
    public void DeleteEmployee(Long id);

}
