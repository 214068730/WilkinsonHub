package com.assignment5.customer;

import com.assignment5.employee.Employee;
import com.assignment5.shop.Item;
import com.assignment5.shop.PrintRefund;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by student on 2016/03/31.
 */

public class Customer implements IComment,RequestItem,PrintRefund,IReturns {

    String customerCode;
    String custName;
    Employee employee;
    DateFormat dateFormat;
    Date date;




    public Customer(CustomerBuild customerBuild){
        customerCode = customerBuild.customerCode;
        custName = customerBuild.custName;
        dateFormat = customerBuild.dateFormat;
        date = customerBuild.date;
        employee = customerBuild.employee;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCustName() {
        return custName;
    }


    @Override
    public String toString() {
        return "customerCode:" + customerCode + '\t'+"custName:" + custName ;
    }

    public void comment(String comment) {
        System.out.println("Comment made by: "+custName);
        System.out.println(comment);
    }

    public void getRequestItem(String requestItem) {
        System.out.println("Customer: "+custName);
            System.out.println("Requested: "+requestItem);
    }

    public void printRefund() {
        System.out.println("Refund\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee name: "+employee.getName());
        System.out.println(custName +" has been awarded a refund");
    }

    public void returnItem(Item item) {
        System.out.println(item.getItemName()+" has been returned by "+custName);
    }

    public static class CustomerBuild{
        String customerCode;
        String custName;
        Employee employee;
        DateFormat dateFormat;
        Date date;


        public CustomerBuild custCode(String customerCode){
            this.customerCode = customerCode;
            return this;
        }

        public CustomerBuild custName(String customerName){
            this.custName = customerName;
            return this;
        }

        public CustomerBuild employee(Employee employee){
            this.employee = employee;
            return this;
        }

        public CustomerBuild dateFormat(){
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return this;
        }

        public CustomerBuild date(){
            date = new Date();
            return this;
        }

        public CustomerBuild copy(Customer customer,Employee employee){
            this.customerCode = customer.customerCode;
            this.custName = customer.custName;
            this.employee = employee;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }

    }

}
