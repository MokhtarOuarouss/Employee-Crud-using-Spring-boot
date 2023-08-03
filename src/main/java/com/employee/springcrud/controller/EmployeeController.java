package com.employee.springcrud.controller;

import com.employee.springcrud.model.Employee;
import com.employee.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
//make 2 applications (Spring , React) to connect to each other
//@CrossOrigin(origins = {"http://localhost:3000/"})
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // create employee Rest API
    @PostMapping("/add")
    public String add(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);
        return "New Employee is added";
    }
    //show all Employee in database
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }
    //get employee by id Rest API
    @GetMapping("/getEmp/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    //update Employee using id
    @PutMapping("/updateEmp/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeService.getEmployeeById(id)
                .map(employee -> {
                    employee.setFull_name(newEmployee.getFull_name());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setSalary(newEmployee.getSalary());
                    return employeeService.saveEmployee(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(Math.toIntExact(id));
                    return employeeService.saveEmployee(newEmployee);
                });
    }

    //delete employee
    @GetMapping("/delete-Emp/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        employeeService.DeleteEmployee(id);
        return "Employee deleted successfully";
    }

}
