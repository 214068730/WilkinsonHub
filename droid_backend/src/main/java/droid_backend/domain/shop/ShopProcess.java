package droid_backend.domain.shop;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Siraaj on 08/03/2016.
 */

@Entity
public class ShopProcess implements PaymentMethod, ItemCollection,PrintReciepts, Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long orderNo;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    Item item;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    Employee employee;
   // ArrayList<Item> list;
    Date datePurchased;

    private ShopProcess(){}

    public Long getOrderNo() {
        return orderNo;
    }

    public Date getDate() {
        return datePurchased;
    }

    public ShopProcess(BuildProcess purchaseBuilder){
        DateFormat dateFormat;
        this.orderNo = purchaseBuilder.orderNo;
        this.customer = purchaseBuilder.customer;
        this.employee = purchaseBuilder.employee;
        this.item = purchaseBuilder.item;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        datePurchased = new Date();
       // list = new ArrayList<Item>();
    }

    public void add(Item item){
        //list.add(item);
    }

    public void printReciept(){
        /*System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("OrderNo. "+ orderNo);
        System.out.println("Employee name: "+employee.getName());
        System.out.println(customer.toString());
        System.out.println(list.toString());*/
    }

    @Override
    public void printRefund() {
 /*       System.out.println("Refund\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee name: "+employee.getName());
        System.out.println(customer.getCustName() +" has been awarded a refund");*/
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
        Long orderNo;
        Item item;
        Customer customer;
        Employee employee;


        public BuildProcess orderNo(Long orderNo){
            this.orderNo = orderNo;
            return this;
        }

        public BuildProcess customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public BuildProcess item(Item item){
            this.item = item;
            return this;
        }

        public BuildProcess employee(Employee employee){
            this.employee = employee;
            return this;
        }

        public BuildProcess copy(ShopProcess order){
            this.orderNo = order.orderNo;
            this.customer = order.customer;
            this.employee = order.employee;
            this.item = order.item;
            return this;
        }

        public ShopProcess build(){
            return new ShopProcess(this);
        }
    }
}
