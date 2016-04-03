package com.assignment5.shop.factories;

import com.assignment5.shop.Item;

/**
 * Created by student on 2016/04/03.
 */
public class ItemFactoryImpl implements ItemFactory {
    private static ItemFactoryImpl factory =null;

    private ItemFactoryImpl(){}

    public static ItemFactoryImpl getInstance(){
        if(factory == null)
            factory = new ItemFactoryImpl();
        return factory;
    }

    public Item creatItem(String itemCode, String itemName) {
        Item item = new Item.ItemBuilder().itemCode(itemCode).itemName(itemName).build();
        return item;
    }
}
