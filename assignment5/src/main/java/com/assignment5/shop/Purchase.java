package com.assignment5.shop;

import com.assignment5.customer.Customer;
import com.assignment5.employee.Employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by student on 2016/03/31.
 */
public class Purchase implements PrintReciept,PaymentMethod,IDelivary {
    Item item;
    Customer customer;
    ArrayList<Item> list;
    Employee employee;
    DateFormat dateFormat;
    Date date;

    public Purchase(BuildPurchase purchaseBuilder){
        this.customer = purchaseBuilder.customer;
        this.employee = purchaseBuilder.employee;
        this.dateFormat = purchaseBuilder.dateFormat;
        this.date = purchaseBuilder.date;
        this.list = purchaseBuilder.list;
    }

    public void add(Item item){
        list.add(item);
    }

    public void printReciept(){
        System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee name: "+employee.getName());
        System.out.println(customer.toString());
        System.out.println(list.toString());
    }

    public void payMethod(String paymentMethod){
        System.out.println("Payment method: "+paymentMethod);
    }

    public void deliver() {
        System.out.println("Customer has requested a delivary");
    }

    public static class BuildPurchase{
        Item item;
        Customer customer;
        ArrayList<Item> list;
        Employee employee;
        DateFormat dateFormat;
        Date date;

        public BuildPurchase customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public BuildPurchase employee(Employee employee){
            this.employee = employee;
            return this;
        }

        public BuildPurchase dateFormat(){
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return this;
        }

        public BuildPurchase date(){
            date = new Date();
            return this;
        }

        public BuildPurchase list(){
            list = new ArrayList<Item>();
            return this;
        }

        public BuildPurchase copy(Customer customer,Employee employee){
            this.customer = customer;
            this.employee = employee;
            return this;
        }

        public Purchase builder(){
            return new Purchase(this);
        }

    }
}
