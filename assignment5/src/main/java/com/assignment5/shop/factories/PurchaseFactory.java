package com.assignment5.shop.factories;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;
import com.assignment5.shop.Purchase;

/**
 * Created by student on 2016/04/03.
 */
public interface PurchaseFactory {
    public Purchase purchaseMachine(Customer customer,Employee employee);
}
