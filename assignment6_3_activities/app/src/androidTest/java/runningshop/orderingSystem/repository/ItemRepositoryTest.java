package runningshop.orderingSystem.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.orderingSystem.domain.shop.Item;
import runningshop.orderingSystem.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.orderingSystem.repository.shop.ItemRepository;

/**
 * Created by Siraaj on 04/23/2016.
 */
public class ItemRepositoryTest extends AndroidTestCase {
    public static final String TAG = "ITEM TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ItemRepository repo = new ItemRepositoryImpl(this.getContext());


        //Create
        Item item = new Item.ItemBuilder()
                .itemName("Juice")
                .build();
        Item insertItem = repo.save(item);
        id = insertItem.getItemCode();
        Assert.assertNotNull(TAG+" CREATE",insertItem);


        //READ ALL
        Set<Item> items = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",items.size()>0);

        //READ entity
        Item entity = repo.findByid(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //update entity
        Item updateItem = new Item.ItemBuilder()
                .copy(entity)
                .itemName("Chocolate")
                .build();
        repo.update(updateItem);
        Item newEntity = repo.findByid(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Chocolate", newEntity.getItemName());

        //DELETE ENTITY
        repo.delete(updateItem);
        Item deletedItem = repo.findByid(id);
        Assert.assertNull(TAG+" DELETE",deletedItem);


        //Delete ALL
        repo.deleteAll();



    }
}
