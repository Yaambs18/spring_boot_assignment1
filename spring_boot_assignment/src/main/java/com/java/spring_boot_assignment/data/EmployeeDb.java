package com.java.spring_boot_assignment.data;

import com.java.spring_boot_assignment.model.Department;
import com.java.spring_boot_assignment.model.Employee;

import java.util.List;

public interface EmployeeDb {

    int insertEmployee(Employee employee);

    int insertDepartment(Department department);

    List<Employee> selectAllEmployee();

    List<Department> selectAllDepartment();

    List<Employee> selectEmployee(int id);

    List<Department> selectDepartment(int id);

}
