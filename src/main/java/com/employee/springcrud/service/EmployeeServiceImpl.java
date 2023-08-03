package com.employee.springcrud.service;

import com.employee.springcrud.model.Employee;
import com.employee.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long  id) {
        return employeeRepository.findById(Math.toIntExact(id));
    }

    @Override
    public void  DeleteEmployee(Long id) {
        employeeRepository.deleteById(Math.toIntExact(id));
    }
}
