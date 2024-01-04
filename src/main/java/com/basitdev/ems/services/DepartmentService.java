package com.basitdev.ems.services;

import com.basitdev.ems.models.Department;
import com.basitdev.ems.models.Position;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

    private static final List<Department> departments = List.of(
            new Department(UUID.randomUUID().toString(), "IT", "London", Position.MANAGER),
            new Department(UUID.randomUUID().toString(), "HR", "New York", Position.TEAMLEADER),
            new Department(UUID.randomUUID().toString(), "Finance", "Paris", Position.SUPERVISOR),
            new Department(UUID.randomUUID().toString(), "Marketing", "Tokyo", Position.MEMBER),
            new Department(UUID.randomUUID().toString(), "Sales", "Berlin", Position.MEMBER),
            new Department(UUID.randomUUID().toString(), "Research", "Oslo", Position.MEMBER)
    );

    public List<Department> getAllDepartments() {
        return departments;
    }
}
