package droid_backend.factory;

import droid_backend.domain.shop.Item;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class ItemFactory {
    public static Item getItem(Long itemCode, String itemName){
        return new Item.ItemBuilder().itemCode(itemCode).itemName(itemName).build();
    }
}
