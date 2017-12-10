package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void mapToBoardsTest() throws URISyntaxException {
        //Given

        Employee employee = new Employee("97112100123", "namie", "lastnamie", BigDecimal.valueOf(10));

        assertEquals("97112100123", employee.getPeselId());
        assertEquals("namie", employee.getFirstName());
        assertEquals("lastnamie", employee.getLastName());
        assertEquals(BigDecimal.valueOf(10), employee.getBaseSalary());
    }



}
