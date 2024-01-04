package com.basitdev.ems.services;

import com.basitdev.ems.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EmployeeService {

    List <Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(UUID id);
    void deleteEmployeeById(UUID id);
    void seedData();

}
