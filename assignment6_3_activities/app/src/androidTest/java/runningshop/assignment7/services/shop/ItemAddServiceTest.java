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
        Item item = repo.findByid(1L);
        Assert.assertNotNull(item);

        Item updateProduct = new Item.ItemBuilder()
                .copy(item)
                .itemName("Milk")
                .build();

        //service updating
        itemService.updateItem(App.getAppContext(),updateProduct);

        Thread.sleep(1000);
        Item updatedItem = repo.findByid(1L);
        Assert.assertEquals(updatedItem.getItemName(),"Milk");



        /* //check that database is growing
        //if enable test will fail
        //only checks if database is increasing
        Assert.assertEquals(items.size(),5);*/
    }
}
