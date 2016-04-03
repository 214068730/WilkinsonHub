package com.assignment5.shop.factories;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;
import com.assignment5.shop.Purchase;

/**
 * Created by student on 2016/04/03.
 */
public class PurchaseFactoryImpl implements  PurchaseFactory{
    private static PurchaseFactoryImpl factory = null;

    private PurchaseFactoryImpl(){}

    public static PurchaseFactoryImpl getInstance(){
        if(factory == null)
            factory=new PurchaseFactoryImpl();
        return factory;
    }

    public Purchase purchaseMachine(Customer customer, Employee employee) {
        Purchase purchaseMachine = new Purchase.BuildPurchase().customer(customer).employee(employee).dateFormat().date().list().builder();
        return purchaseMachine;
    }
}
