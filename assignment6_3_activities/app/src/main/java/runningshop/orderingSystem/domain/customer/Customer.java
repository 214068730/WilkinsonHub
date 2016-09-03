package runningshop.orderingSystem.domain.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Item;

/**
 * Created by Siraaj on 04/14/2016.
 */

public class Customer implements IComment,IRequestItem,IReturnItem,ICustomerEvents,Serializable {

    @JsonProperty("customerCode")
    Long customerCode;
    @JsonProperty("custName")
    String custName;
    @JsonProperty("dateCreated")
    Date dateCreated;

    //Map<Long,Date> customerEventsHistory = new HashMap();
    @JsonProperty("address")
    AddressVO address;
    @JsonProperty("postalCode")
    String postal;
    @JsonProperty("streetName")
    String stretName;
    @JsonProperty("suburb")
    String suburb;

    public Customer(){}

    public Customer(CustomerBuild customerBuild){
        DateFormat dateFormat;
        customerCode = customerBuild.customerCode;
        custName = customerBuild.custName;
        dateCreated = customerBuild.dateCreated;
        address = customerBuild.address;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateCreated = new Date();
        //customerAccountCreated();
    }

    public Long getCustomerCode() {
        return customerCode;
    }

    public String getCustName() {
        return custName;
    }

    public AddressVO getAddress(){
        return address;
    }

    public String getPostalCode(){
        return address.getPostalCode();
    }

    public String getStreetName(){
        return address.getStreetName();
    }

    public String getSuburb(){
        return address.getSuburb();
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
        // customerEventsHistory.put(customerCode, date);

    }

    public void viewCustomerAccount(Long customerCode){
        /*if(!customerEventsHistory.get(customerCode).equals(null)) {
            System.out.println("Account Created on");
            System.out.println(customerEventsHistory.get(customerCode));
            System.out.println("Account number: "+customerCode);
            System.out.println("Customer Name: "+custName);
        }*/
    }

    public void viewCustomer(){
        System.out.println("Customer Code: "+customerCode);
        System.out.println("Customer Name: "+custName);
        System.out.println("Address Details:");
        address.viewAddress();
    }

    public static class CustomerBuild{
        Long customerCode;
        String custName;
        DateFormat dateFormat;
        @JsonProperty("address")
        Date dateCreated;

        AddressVO address;


        public CustomerBuild custCode(Long customerCode){
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerCode == customer.customerCode;

    }

    @Override
    public int hashCode() {
        return (int) (customerCode ^ (customerCode >>> 32));
    }

}
