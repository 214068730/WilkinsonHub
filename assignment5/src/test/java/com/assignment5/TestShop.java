package com.assignment5;

import com.assignment5.shop.Shop;
import com.assignment5.shop.factories.ShopFactory;
import com.assignment5.shop.factories.ShopFactoryImp;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class TestShop {
    private ShopFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = ShopFactoryImp.getInstance();
    }

    @Test
    public void testShopCreation() throws Exception {
        Shop shop = factory.createShop("SiKash");
        shop.shopStatusOpen();
        Assert.assertEquals(shop.getShopName(),"SiKash");
        shop.shopstatusClosed();
    }

    @Test
    public void testShopUpdate() throws Exception {
        Shop shop = factory.createShop("SiKash");
        Assert.assertEquals(shop.getShopName(),"SiKash");
        shop.displayLogo();

        //update
        Shop shopUpdate = new Shop.ShopBuilder().copy(shop).name("Bev's Trendy Shop").build();
        Assert.assertEquals(shopUpdate.getShopName(),"Bev's Trendy Shop");
        shopUpdate.displayLogo();
    }
}
