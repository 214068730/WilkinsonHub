package runningshop.assignment6.factories.shop;

import runningshop.assignment6.domain.shop.Item;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ItemFactory {
    public static Item getItem(String itemCode,String itemName){
        return new Item.ItemBuilder().itemCode(itemCode).itemName(itemName).build();
    }
}
