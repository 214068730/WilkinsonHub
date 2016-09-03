package runningshop.orderingSystem.services.shop;

import android.content.Context;

import runningshop.orderingSystem.domain.shop.Item;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface AddItemService {
    void addItem(Context context,Item item);
    void updateItem(Context context,Item item);
    void deleteItem(Context context,Item item);
}
