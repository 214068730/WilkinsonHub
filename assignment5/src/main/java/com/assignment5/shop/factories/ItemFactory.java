package com.assignment5.shop.factories;

import com.assignment5.shop.Item;

/**
 * Created by student on 2016/04/03.
 */
public interface ItemFactory {
    public Item creatItem(String itemCode, String itemName);
}
