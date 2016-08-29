package runningshop.assignment7.services.shop;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.assignment7.repository.shop.ItemRepository;
import runningshop.assignment7.services.shop.Impl.ItemRemoveServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 * TO use the remove service you have to add to the database first
 */
public class ItemRemoveServiceTest extends AndroidTestCase {
    public void testDeleteItem() throws Exception {

        ItemRepository repo = new ItemRepositoryImpl(App.getAppContext());
        ItemRemoveService itemService= ItemRemoveServiceImpl.getInstance();


        //Get item from database
        Item product = repo.findByid(2L);

        //service to delete item
        itemService.deleteItem(App.getAppContext(), product);

        Thread.sleep(1000);
        //Delete
        Item deletedItem = repo.findByid(2L);
        Assert.assertNull(deletedItem);
    }
}
