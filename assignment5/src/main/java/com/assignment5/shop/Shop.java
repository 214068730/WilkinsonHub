package com.assignment5.shop;

/**
 * Created by student on 2016/04/01.
 */

public class Shop implements IShop {
    String status;
    String shopName;

    public Shop(ShopBuilder shopBuilder) {
       this.shopName = shopBuilder.shopName;
    }

    public String getStatus() {
        return status;
    }
    public String getShopName() {
        return shopName;
    }

    public void displayLogo(){
        System.out.println(shopName);
    }

    public void shopStatusOpen(){
        status = "Open";
        System.out.println(shopName+" is "+status);
    }

    public void shopstatusClosed(){
        status = "Closed";
        System.out.println(shopName+" is "+status);
    }


    public static  class ShopBuilder{
        String status;
        String shopName;

        public ShopBuilder status(String status){
            this.status = status;
            return this;
        }

        public ShopBuilder name(String shopName){
            this.shopName = shopName;
            return this;
        }

        public ShopBuilder copy(Shop shop){
            this.shopName = shop.shopName;
            this.status = shop.status;

            return this;
        }

        public Shop build(){
            return new Shop(this);
        }

    }
}
