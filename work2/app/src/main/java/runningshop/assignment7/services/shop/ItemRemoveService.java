package runningshop.assignment7.services.shop;

import android.content.Context;

import runningshop.assignment7.domain.shop.Item;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface ItemRemoveService {
    void deleteItem(Context context,Item item );
}
