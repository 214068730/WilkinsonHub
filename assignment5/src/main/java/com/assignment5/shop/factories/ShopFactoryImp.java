package com.assignment5.shop.factories;

import com.assignment5.shop.Shop;

/**
 * Created by student on 2016/04/03.
 */
public class ShopFactoryImp implements  ShopFactory {
    private static ShopFactoryImp factory = null;


    private ShopFactoryImp(){

    }

    public static ShopFactoryImp getInstance(){
        if(factory == null)
            factory = new ShopFactoryImp();
        return factory;

    }

    public Shop createShop(String shopName) {
       Shop shop = new Shop.ShopBuilder().name(shopName).build();
        return shop;
    }
}
