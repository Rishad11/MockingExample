package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    public void testEmployeeId() {
        Employee employee = new Employee("123", 50000.0);
        assertEquals("123", employee.getId());
        employee.setId("456");
        assertEquals("456", employee.getId());
    }

    @Test
    public void testEmployeeSalary() {
        Employee employee = new Employee("789", 60000.0);
        assertEquals(60000.0, employee.getSalary());
        employee.setSalary(70000.0);
        assertEquals(70000.0, employee.getSalary());
    }

    @Test
    public void testEmployeeIsPaid() {
        Employee employee = new Employee("101", 80000.0);
        assertFalse(employee.isPaid());
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    public void testEmployeeToString() {
        Employee employee = new Employee("123", 50000.0);
        assertEquals("Employee [id=123, salary=50000.0]", employee.toString());
    }
}
