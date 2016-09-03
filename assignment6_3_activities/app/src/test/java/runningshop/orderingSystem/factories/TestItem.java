package runningshop.orderingSystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.orderingSystem.domain.shop.Item;
import runningshop.orderingSystem.factories.shop.ItemFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestItem {

    @Test
    public void testCreateItem() throws Exception {
        Item item1 = ItemFactory.getItem(100L,"Chocolate");

        Assert.assertEquals(item1.getItemName(),"Chocolate");
        System.out.println(item1.toString());

        item1.viewItemHistory(100L);
    }

    @Test
    public void testItemUpdate() throws Exception {
        Item item = ItemFactory.getItem(100L,"Chocolate");
        Item itemUpdate = new Item.ItemBuilder()
                .copy(item)
                .itemName("Becon Chocolate")
                .build();
        Assert.assertEquals(itemUpdate.getItemName(), "Becon Chocolate");
        System.out.println(itemUpdate.toString());

    }
}
