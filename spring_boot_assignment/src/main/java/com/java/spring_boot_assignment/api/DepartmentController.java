package com.java.spring_boot_assignment.api;

import com.java.spring_boot_assignment.model.Department;
import com.java.spring_boot_assignment.model.Employee;
import com.java.spring_boot_assignment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    private final EmployeeService employeeService;

    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addDepartment(@RequestBody Department department){
        employeeService.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return employeeService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public List<Department> getDepartment(@PathVariable("id") int id){
        return employeeService.getDepartment(id);
    }
}
