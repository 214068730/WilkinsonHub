package runningshop.assignment6.domain.shop;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import runningshop.assignment6.domain.customer.Customer;
import runningshop.assignment6.domain.employee.Employee;

/**
 * Created by Siraaj on 04/17/2016.
 */

    public class ShopProcess implements PaymentMethod, ItemCollection,PrintReciepts, Serializable {
        Item item;
        Customer customer;
        ArrayList<Item> list;
        Employee employee;
        DateFormat dateFormat;
        Date date;

        public ShopProcess(BuildProcess purchaseBuilder){
            this.customer = purchaseBuilder.customer;
            this.employee = purchaseBuilder.employee;
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            date = new Date();
            list = new ArrayList<Item>();
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

        @Override
        public void printRefund() {
            System.out.println("Refund\n\t\t\t\t"+dateFormat.format(date));
            System.out.println("Employee name: "+employee.getName());
            System.out.println(customer.getCustName() +" has been awarded a refund");
        }

        public void payMethod(String paymentMethod){
            System.out.println("Payment method: "+paymentMethod);
        }

        @Override
        public void collectionType(String collectionType) {
            System.out.println(customer.getCustName());
            System.out.println("Has requested requested:"+collectionType);
        }


        public static class BuildProcess{
            Item item;
            Customer customer;

            Employee employee;


            public BuildProcess customer(Customer customer){
                this.customer = customer;
                return this;
            }

            public BuildProcess employee(Employee employee){
                this.employee = employee;
                return this;
            }

            public BuildProcess copy(Customer customer,Employee employee){
                this.customer = customer;
                this.employee = employee;
                return this;
            }

            public ShopProcess build(){
                return new ShopProcess(this);
            }

        }

    }
