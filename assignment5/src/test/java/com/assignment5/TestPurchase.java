package com.assignment5;

import com.assignment5.customer.Customer;
import com.assignment5.customer.factory.CustomerFactory;
import com.assignment5.customer.factory.CustomerFactoryImpl;
import com.assignment5.employee.Employee;
import com.assignment5.employee.factories.EmployeeFactory;
import com.assignment5.employee.factories.EmployeeFactoryImpl;
import com.assignment5.shop.Item;
import com.assignment5.shop.Purchase;
import com.assignment5.shop.factories.ItemFactory;
import com.assignment5.shop.factories.ItemFactoryImpl;
import com.assignment5.shop.factories.PurchaseFactory;
import com.assignment5.shop.factories.PurchaseFactoryImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class TestPurchase {
    private PurchaseFactory factory;
    private CustomerFactory customerFactory;
    private EmployeeFactory empFactory;
    private ItemFactory itemFactory;

    @Before
    public void setUp() throws Exception {
        factory = PurchaseFactoryImpl.getInstance();
        customerFactory =  CustomerFactoryImpl.getInstance();
        empFactory = EmployeeFactoryImpl.getInstance();
        itemFactory = ItemFactoryImpl.getInstance();
    }

    @Test
    public void testPurchaseMachine() throws Exception {
        Employee employee = empFactory.createEmployee("001","Shireen","Wilkinson");
        Customer customer = customerFactory.createCustomer("001","Kashiefa",employee);
        Item item = itemFactory.creatItem("001","White Bread");
        Item item2 = itemFactory.creatItem("002","Brown Bread");
        Purchase till = factory.purchaseMachine(customer,employee);
        till.add(item);
        till.add(item2);

        till.payMethod("Cash");
        till.deliver();
        till.printReciept();
    }

    @Test
    public void testPurchaseUpdate() throws Exception {
        Employee employee = empFactory.createEmployee("001","Shireen","Wilkinson");
        Customer customer = customerFactory.createCustomer("001","Kashiefa",employee);
        Item item = itemFactory.creatItem("001","White Bread");
        Item item2 = itemFactory.creatItem("002","Brown Bread");
        Purchase till = factory.purchaseMachine(customer,employee);

        //update
        Employee employeeUpdate = new Employee.EmployeeBuilder().copy(employee).name("Siraaj").build();
        Purchase tillUpdate = new Purchase.BuildPurchase().copy(customer,employee).employee(employeeUpdate).dateFormat().date().list().builder();

        till.add(item);
        tillUpdate.add(item2);

        till.printReciept();
        tillUpdate.printReciept();





    }
}
