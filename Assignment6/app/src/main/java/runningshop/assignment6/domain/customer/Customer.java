package runningshop.assignment6.domain.customer;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.shop.Item;

/**
 * Created by Siraaj on 04/14/2016.
 */
public class Customer implements IComment,IRequestItem,IReturnItem,ICustomerEvents,Serializable {
    String customerCode;
    String custName;
    DateFormat dateFormat;
    Date date;
    AddressVO address;
    Map<String,Date> customerEventsHistory = new HashMap();




    public Customer(CustomerBuild customerBuild){
        customerCode = customerBuild.customerCode;
        custName = customerBuild.custName;
        dateFormat = customerBuild.dateFormat;
        date = customerBuild.date;
        address = customerBuild.address;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        customerAccountCreated();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCustName() {
        return custName;
    }

    public AddressVO getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "customerCode:" + customerCode + '\t'+"custName:" + custName ;
    }

    public void comment(String comment) {
        System.out.println("Comment made by: "+custName);
        System.out.println(comment);
    }

    public void RequestItem(String requestItem) {
        System.out.println("Customer: "+custName);
        System.out.println("Requested: "+requestItem);
    }


    public void returnItem(Item item) {
        System.out.println(item.getItemName()+" has been returned by "+custName);
    }

    @Override
    public void customerAccountCreated() {
        customerEventsHistory.put(customerCode, date);

    }

    public void viewCustomerAccount(String customerCode){
        if(!customerEventsHistory.get(customerCode).equals(null)) {
            System.out.println("Account Created on");
            System.out.println(customerEventsHistory.get(customerCode));
            System.out.println("Account number: "+customerCode);
            System.out.println("Customer Name: "+custName);
        }
    }

    public void viewCustomer(){
        System.out.println("Customer Code: "+customerCode);
        System.out.println("Customer Name: "+custName);
        System.out.println("Address Details:");
        address.viewAddress();
    }

    public static class CustomerBuild{
        String customerCode;
        String custName;
        DateFormat dateFormat;
        Date date;
        AddressVO address;


        public CustomerBuild custCode(String customerCode){
            this.customerCode = customerCode;
            return this;
        }

        public CustomerBuild custName(String customerName){
            this.custName = customerName;
            return this;
        }


        public CustomerBuild address(AddressVO address) {
            this.address = address;
            return this;
        }

        public CustomerBuild copy(Customer customer){
            this.customerCode = customer.customerCode;
            this.custName = customer.custName;
            this.address = customer.address;
            return this;
        }

        public Customer build(){
            return new Customer(this);

        }
    }
}
