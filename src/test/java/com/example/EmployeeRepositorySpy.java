package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositorySpy implements EmployeeRepository {

    private List<Employee> findAllResult;
    private final List<Employee> saveResults;

    public EmployeeRepositorySpy() {
        findAllResult = new ArrayList<>();
        saveResults = new ArrayList<>();
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(findAllResult);
    }

    @Override
    public Employee save(Employee employee) {
        saveResults.add(employee);
        return employee;
    }
}
