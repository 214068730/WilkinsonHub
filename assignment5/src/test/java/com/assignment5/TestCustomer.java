package com.assignment5;

import com.assignment5.customer.Customer;
import com.assignment5.customer.factory.CustomerFactory;
import com.assignment5.customer.factory.CustomerFactoryImpl;
import com.assignment5.employee.Employee;
import com.assignment5.employee.factories.EmployeeFactory;
import com.assignment5.employee.factories.EmployeeFactoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class TestCustomer {
    private CustomerFactory factory;
    private EmployeeFactory empFactory;

    @Before
    public void setUp() throws Exception {
        factory =  CustomerFactoryImpl.getInstance();
        empFactory = EmployeeFactoryImpl.getInstance();

    }

    @Test
    public void testCustomerCreation() throws Exception {
        Employee employee = empFactory.createEmployee("001","Shireen","Wilkinson");
        Customer customer = factory.createCustomer("001","Kashiefa",employee);

        Assert.assertEquals(customer.getCustName(),"Kashiefa");
        Assert.assertEquals(customer.getCustomerCode(),"001");
        customer.printRefund();
    }

    @Test
    public void testCustomerUpdate() throws Exception {
        Employee employee = empFactory.createEmployee("001","Shireen","Wilkinson");
        Customer customer = factory.createCustomer("001","Kashiefa",employee);

        Assert.assertEquals(customer.getCustName(),"Kashiefa");

        Customer customerUpdate = new Customer.CustomerBuild().copy(customer,employee).custName("Shahiem").build();
        Assert.assertEquals(customerUpdate.getCustName(),"Shahiem");

    }
}
