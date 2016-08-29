package runningshop.assignment7.services.shop;

import android.content.Context;

import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.domain.shop.Item;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface AddItemService {
    void addItem(Context context,Item item);
    void updateItem(Context context,Item item);
    void deleteItem(Context context,Item item);
}
