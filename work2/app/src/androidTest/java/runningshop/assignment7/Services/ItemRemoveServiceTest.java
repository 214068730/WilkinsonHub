package runningshop.assignment7.Services;

import android.app.Activity;
import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.assignment7.repository.shop.ItemRepository;
import runningshop.assignment7.services.shop.AddItemService;
import runningshop.assignment7.services.shop.Impl.AddItemServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class ItemRemoveServiceTest extends AndroidTestCase {
    public void testDeleteItem() throws Exception {
        ItemRepository repo = new ItemRepositoryImpl(this.getContext());
        Long id;


        Intent intent = new Intent(App.getAppContext(),AddItemServiceImpl.class);
        AddItemService itemService= new AddItemServiceImpl();

        Item product = new Item.ItemBuilder()
                .itemName("Choc")
                .build();

        itemService.addItem(App.getAppContext(),product);
        id = product.getItemCode();
        //App.getAppContext().startService(intent);

        Assert.assertNotNull("CREATE", product);

        //Delete
        repo.delete(product);
        Item deletedItem = repo.findByid(id);
        Assert.assertNull(" DELETE", deletedItem);

    }
}
