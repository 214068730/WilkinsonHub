package com.assignment5.shop;

import com.assignment5.customer.Customer;

/**
 * Created by student on 2016/04/01.
 */
public class Rate implements IRate {

    private Item item;
    private Customer customer;

    public Rate(RateBuilder rateBuilder) {
        this.item = rateBuilder.item;
        this.customer = rateBuilder.customer;
    }

    public void rateProduct(int rateProduct) {
        System.out.println("Customer: "+customer.getCustName());
        System.out.println("Rated "+item.getItemName()+" "+rateProduct+" out of 10");
    }

    public void rateShopService(int rateShopService) {
        System.out.println("Customer: "+customer.getCustName());
        System.out.println("Rated the service of the shop"+rateShopService+" out of 10");
    }

    public static class RateBuilder{
        private Item item;
        private Customer customer;

        public RateBuilder item(Item item){
            this.item = item;
            return this;
        }

        public RateBuilder customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public RateBuilder copy(Item item,Customer customer){
            this.item = item;
            this.customer = customer;
            return this;
        }

        public Rate build(){
            return new Rate(this);
        }
    }
}
