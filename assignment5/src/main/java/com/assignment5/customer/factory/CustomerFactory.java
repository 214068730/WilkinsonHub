package com.assignment5.customer.factory;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;

/**
 * Created by student on 2016/04/03.
 */
public interface CustomerFactory {
    public Customer createCustomer(String custCode,String custName,Employee employee);
}
