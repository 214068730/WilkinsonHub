package com.assignment5;

import com.assignment5.shop.Item;
import com.assignment5.shop.factories.ItemFactory;
import com.assignment5.shop.factories.ItemFactoryImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class TestItem {
    private ItemFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = ItemFactoryImpl.getInstance();
    }

    @Test
    public void testItemCreation() throws Exception {
        Item item = factory.creatItem("001","Bread");
        Assert.assertEquals(item.getItemName(),"Bread");
        Assert.assertEquals(item.getItemCode(),"001");
    }

    @Test
    public void testItemUpdate() throws Exception {
        Item item = factory.creatItem("001","Bread");
        System.out.println("Before: "+item.getItemName());

        //update
        Item itemUpdate = new Item.ItemBuilder().copy(item).itemName("Brown Bread").build();
        System.out.println("After: "+itemUpdate.getItemName());

    }
}
