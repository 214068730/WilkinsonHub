package com.assignment5;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;
import com.assignment5.shop.Item;
import com.assignment5.shop.Purchase;
import com.assignment5.shop.Shop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Employee employee = new Employee.EmployeeBuilder().employeeCode("E001").name("Shireen").surname("Wilkinson").build();
        Customer customer= new Customer.CustomerBuild().custCode("C001").custName("Siraaj").employee(employee).dateFormat().date().build();

        Shop shop = new Shop.ShopBuilder().name("SiKash").build();


        Purchase till = new Purchase.BuildPurchase().customer(customer).employee(employee).dateFormat().date().list().builder();
        Item item = new Item.ItemBuilder().itemCode("001").itemName("Bread").build();
        Item item2 = new Item.ItemBuilder().itemCode("001").itemName("Juice").build();


        shop.shopStatusOpen();

        till.add(item);
        till.add(item2);
        till.payMethod("\nCredit card\n");
        till.deliver();
        till.printReciept();
        customer.printRefund();
        customer.returnItem(item);
        customer.comment("Good service\n");
        customer.getRequestItem("Coke\n");

        shop.shopstatusClosed();


    }
}
