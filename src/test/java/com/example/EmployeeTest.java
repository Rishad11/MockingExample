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
}
