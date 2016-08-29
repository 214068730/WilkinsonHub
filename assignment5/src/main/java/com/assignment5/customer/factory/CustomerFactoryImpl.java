package com.assignment5.customer.factory;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;

/**
 * Created by student on 2016/04/03.
 */
public class CustomerFactoryImpl implements CustomerFactory{

    private static CustomerFactoryImpl factory = null;

    private CustomerFactoryImpl(){

    }

    public static CustomerFactoryImpl getInstance(){
        if(factory == null)
            factory = new CustomerFactoryImpl();
        return factory;
    }

    public Customer createCustomer(String custCode, String custName, Employee employee) {
        Customer customer = new Customer.CustomerBuild().custCode(custCode).custName(custName).employee(employee).dateFormat().date().build();
        return customer;
    }
}
