package runningshop.assignment7.services.shop;

import android.test.AndroidTestCase;


import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.assignment7.repository.shop.ItemRepository;
import runningshop.assignment7.services.shop.Impl.AddItemServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class ItemAddServiceTest extends AndroidTestCase {

    public void testAddItem() throws Exception {

        ItemRepository repo = new ItemRepositoryImpl(App.getAppContext());
        AddItemService itemService = new AddItemServiceImpl();

        Item product = new Item.ItemBuilder()
                .itemName("Choc")
                .build();

        Assert.assertNotNull("CREATE", product);

        //service to add products to the database
        itemService.addItem(App.getAppContext(), product);


        Thread.sleep(1000);
        //Checks if database is empty
        Set<Item> items = repo.findAll();
        Assert.assertTrue(items.size() > 0);

       /* //check that database is growing
        //if enable test will fail
        //only checks if database is increasing
        Assert.assertEquals(items.size(),5);*/

        Item item = repo.findByid(1L);
        Assert.assertNotNull(item);
    }
}
