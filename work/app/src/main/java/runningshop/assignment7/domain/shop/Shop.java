package runningshop.assignment7.domain.shop;

import java.io.Serializable;

import runningshop.assignment7.domain.address.AddressVO;

/**
 * Created by Siraaj on 04/14/2016.
 */
public class Shop implements Serializable{
    Long shopID;
    String shopName;
    AddressVO address;
    public Shop(BuildShop shopBuilder){
        shopID = shopBuilder.shopID;
        shopName = shopBuilder.shopName;
        address = shopBuilder.address;
    }

    public Long getShopID() {
        return shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public AddressVO getAddress() {
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
    public void viewShop(){
        System.out.println("Shop ID: "+shopID);
        System.out.println("Shop Name: "+shopName);
        System.out.println("Address:");
        address.viewAddress();
    }

    // builder
    public static class BuildShop{
        Long shopID;
        String shopName;
        AddressVO address;


        public BuildShop shopID(Long shopID){
            this.shopID = shopID;
            return this;
        }

        public BuildShop shopName(String shopName){
            this.shopName = shopName;
            return this;
        }

        public BuildShop address(AddressVO address){
            this.address = address;
            return this;
        }

        public BuildShop copy(Shop shop){
            this.shopID = shop.shopID;
            this.shopName = shop.shopName;
            this.address = shop.address;
            return this;
        }

        public Shop build(){
            return new Shop(this);
        }
    }
}
