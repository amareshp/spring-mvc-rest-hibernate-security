package com.visitamaresh.ws.dao;

import java.util.List;

import com.visitamaresh.ws.model.Employee;
 
public interface EmployeeDao {
 
    void saveEmployee(Employee employee);
     
    List<Employee> findAllEmployees();
     
    void deleteEmployeeBySsn(String ssn);
     
    Employee findBySsn(String ssn);
     
    void updateEmployee(Employee employee);
}