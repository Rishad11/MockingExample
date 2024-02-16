package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EmployeesTest {

    @Test
    public void testPayEmployeesSuccessfully() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        Employees employees = new Employees(employeeRepository, bankService);

        List<Employee> mockEmployees = List.of(new Employee("1", 1000.0));
        when(employeeRepository.findAll()).thenReturn(mockEmployees);
        when(bankService.pay(eq("1"), eq(1000.0))).thenReturn(true);

        int payments = employees.payEmployees();

        verify(bankService, times(1)).pay(eq("1"), eq(1000.0));

        assertTrue(mockEmployees.get(0).isPaid());

    }

    @Test
    public void testPayEmployeesUnsuccessfullyWithStubAndSpy() {
        EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
        BankServiceStub bankServiceStub = new BankServiceStub(false);
        Employees employees = new Employees(employeeRepositorySpy, bankServiceStub);

        int payments = employees.payEmployees();

        assertEquals(0, payments);
    }
}

