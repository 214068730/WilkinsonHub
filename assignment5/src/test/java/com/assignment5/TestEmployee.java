package com.assignment5;

import com.assignment5.employee.factories.CashierEmployee;
import com.assignment5.employee.Employee;
import com.assignment5.employee.factories.IEmployee;
import com.assignment5.employee.factories.PackerEmployee;
import com.assignment5.employee.factories.EmployeeFactory;
import com.assignment5.employee.factories.EmployeeFactoryImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class TestEmployee {
    private EmployeeFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = EmployeeFactoryImpl.getInstance();
    }

    @Test
    public void testEmployeeCreation() throws Exception {
        Employee employee = factory.createEmployee("001","Bev","Wilkinson");
        Assert.assertEquals(employee.getName(),"Bev");
        Assert.assertEquals(employee.getSurname(),"Wilkinson");
        Assert.assertEquals(employee.getEmpCode(),"001");
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        Employee employee = factory.createEmployee("001","Bev","Wilkinson");
        Assert.assertEquals(employee.getName(),"Bev");

        Employee empUpdate = new Employee.EmployeeBuilder().copy(employee).name("Shireen").build();
        Assert.assertEquals(empUpdate .getName(),"Shireen");

    }


    @Test
    public void testEmployeeDetails() throws Exception {
        IEmployee emp1 = new PackerEmployee();
        IEmployee emp2 = new CashierEmployee();

        emp1.setNextChain(emp2);
        emp1.employeeTitle("cashier","001","Shireen","Wilkinson");

    }
}
