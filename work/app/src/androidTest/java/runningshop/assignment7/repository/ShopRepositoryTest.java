package runningshop.assignment7.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Shop;
import runningshop.assignment7.repository.shop.Impl.ShopRepositoryImpl;
import runningshop.assignment7.repository.shop.ShopRepository;

/**
 * Created by Siraaj on 04/24/2016.
 */
public class ShopRepositoryTest extends AndroidTestCase {
    private static final String TAG= "SHOP TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ShopRepository repo = new ShopRepositoryImpl(this.getContext());

        //CREATE
        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow Road")
                .suburb("Mitchell's plain")
                .build();

        Shop createEntity = new Shop.BuildShop()
                .shopName("Bev Trendy Shop")
                .address(address)
                .build();

        Shop insertedEntity = repo.save(createEntity);
        id = insertedEntity.getShopID();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);


        //READ ALL
        Set<Shop> shops = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",shops.size()>0);

        //READ ENTITY
        Shop entity = repo.findByid(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        Shop updateEntity = new Shop.BuildShop()
                .copy(entity)
                .shopName("TrEnDy SHOP")
                .build();

        repo.update(updateEntity);
        Shop newEntity = repo.findByid(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TrEnDy SHOP",newEntity.getShopName());

        //DELETE ENTITY
        repo.delete(updateEntity);
        Shop deletedEntity = repo.findByid(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        //DeleteAll
        repo.deleteAll();


    }
}
