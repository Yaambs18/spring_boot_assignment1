package com.java.spring_boot_assignment.api;

import com.java.spring_boot_assignment.model.Employee;
import com.java.spring_boot_assignment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{empId}")
    public List<Employee> getEmployee(@PathVariable("empId") int id){
        return employeeService.getEmployee(id);
    }

}
