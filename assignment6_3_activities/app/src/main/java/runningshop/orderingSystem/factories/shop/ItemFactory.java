package runningshop.orderingSystem.factories.shop;

import runningshop.orderingSystem.domain.shop.Item;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ItemFactory {
    public static Item getItem(Long itemCode,String itemName){
        return new Item.ItemBuilder().itemCode(itemCode).itemName(itemName).build();
    }
}
