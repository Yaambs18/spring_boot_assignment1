package com.java.spring_boot_assignment.service;

import com.java.spring_boot_assignment.data.EmployeeDb;
import com.java.spring_boot_assignment.model.Department;
import com.java.spring_boot_assignment.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDb employeeDb;

    @Autowired
    public EmployeeService(EmployeeDb employeeDb) {
        this.employeeDb = employeeDb;
    }

    public int addEmployee(Employee employee){
        return employeeDb.insertEmployee(employee);
    }

    public int addDepartment(Department department){
        return employeeDb.insertDepartment(department);
    }

    public List<Employee> getAllEmployee(){
        return employeeDb.selectAllEmployee();
    }

    public List<Department> getAllDepartment(){
        return employeeDb.selectAllDepartment();
    }

    public List<Employee> getEmployee(int empId){
        return employeeDb.selectEmployee(empId);
    }

    public List<Department> getDepartment(int id){
        return employeeDb.selectDepartment(id);
    }
}
