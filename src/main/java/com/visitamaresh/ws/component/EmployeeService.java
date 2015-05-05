package com.visitamaresh.ws.component;

import java.util.List;

import com.visitamaresh.ws.model.Employee;
 
public interface EmployeeService {
 
    void saveEmployee(Employee employee);
 
    List<Employee> findAllEmployees();
 
    void deleteEmployeeBySsn(String ssn);
 
    Employee findBySsn(String ssn);
 
    void updateEmployee(Employee employee);
}