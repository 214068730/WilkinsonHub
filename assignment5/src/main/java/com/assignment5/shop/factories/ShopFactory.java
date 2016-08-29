package com.assignment5.shop.factories;

import com.assignment5.shop.Shop;

/**
 * Created by student on 2016/04/03.
 */
public interface ShopFactory {
    public Shop createShop(String shopName);
}
