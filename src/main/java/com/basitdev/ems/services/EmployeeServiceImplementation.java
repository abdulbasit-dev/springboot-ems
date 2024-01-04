package com.basitdev.ems.services;

import com.basitdev.ems.models.Employee;
import com.basitdev.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().reversed();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(" Employee not found for id :: " + id);

        return employee;
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void seedData() {
        //sout in red color that deletes all data
        System.out.println("\u001B[31m" + "Deleting all data..." + "\u001B[0m");
        
        //delete all data
        employeeRepository.deleteAll();

        //change color of sout to yellow
        System.out.println("\u001B[33m" + "Seeding data..." + "\u001B[0m");

        // create employees
        List<Employee> employees = List.of(
                new Employee(UUID.randomUUID(), "James", "Bond", "test@test.com"),
                new Employee(UUID.randomUUID(), "Maria", "Jones", "test@test.com"),
                new Employee(UUID.randomUUID(), "Anna", "Smith", "test@test.com")
        );
        // save to db
        employeeRepository.saveAll(employees);

        //change color of sout to green
        System.out.println("\u001B[32m" + "Data seeded." + "\u001B[0m");

    }
}
