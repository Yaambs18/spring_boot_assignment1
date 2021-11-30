package com.java.spring_boot_assignment.data;

import com.java.spring_boot_assignment.model.Department;
import com.java.spring_boot_assignment.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDataAccessService implements EmployeeDb{

    private static List<Employee> db = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(Employee employee) {
        String insertQuery = "insert into employee(jobTitle, firtsName, lastName, phoneNumber, emailAddress) values(?,?,?,?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getJobTitle());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setLong(4, employee.getPhoneNumber());
            ps.setString(5, employee.getEmailAddress());
            return ps;
        });

        return 1;
    }

    @Override
    public int insertDepartment(Department department) {
        String insertQuery = "insert into department(deptName, phoneNumber, emailAddress) values(?,?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, department.getName());
            ps.setString(2, department.getPhoneNumber());
            ps.setString(3, department.getEmail());
            return ps;
        });

        return 1;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        String sql = "select * from employee";
        List<Employee> query = jdbcTemplate.query(sql, (resultSet, i) -> new Employee(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4),
                Long.parseLong(resultSet.getString(5)), resultSet.getString(6)));
        return query;
    }

    @Override
    public List<Department> selectAllDepartment() {
        String sql = "select * from department";
        List<Department> query = jdbcTemplate.query(sql, (resultSet, i) -> new Department(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4)));
        return query;
    }

    @Override
    public List<Employee> selectEmployee(int empId) {
        String sql = "select * from employee where emp_id="+empId;
        List<Employee> query = jdbcTemplate.query(sql, (resultSet, i) -> new Employee(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4),
                Long.parseLong(resultSet.getString(5)), resultSet.getString(6)));
        return query;
    }

    @Override
    public List<Department> selectDepartment(int id) {
        String sql = "select * from department where deptId="+id;
        List<Department> query = jdbcTemplate.query(sql, (resultSet, i) -> new Department(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4)));
        return query;
    }
}
