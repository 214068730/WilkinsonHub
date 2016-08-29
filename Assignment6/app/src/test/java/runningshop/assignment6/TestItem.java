package runningshop.assignment6;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.assignment6.domain.shop.Item;
import runningshop.assignment6.factories.shop.ItemFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestItem {

    @Test
    public void testCreateItem() throws Exception {
        Item item1 = ItemFactory.getItem("I001","Chocolate");

        Assert.assertEquals(item1.getItemName(),"Chocolate");
        System.out.println(item1.toString());

        item1.viewItemHistory("I001");
    }

    @Test
    public void testItemUpdate() throws Exception {
        Item item = ItemFactory.getItem("I001","Chocolate");
        Item itemUpdate = new Item.ItemBuilder()
                .copy(item)
                .itemName("Becon Chocolate")
                .build();
        Assert.assertEquals(itemUpdate.getItemName(), "Becon Chocolate");
        System.out.println(itemUpdate.toString());

    }
}
