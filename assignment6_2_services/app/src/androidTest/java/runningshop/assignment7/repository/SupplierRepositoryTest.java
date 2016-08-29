package runningshop.assignment7.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;

/**
 * Created by Siraaj on 04/24/2016.
 */
public class SupplierRepositoryTest extends AndroidTestCase {

    public static final String TAG ="SUPPLIER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SupplierRepository repo = new SupplierRepositoryImpl(this.getContext());


        //Create
        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("School Street")
                .suburb("Mitchell's Plain")
                .build();

        Supplier createEntity = new Supplier.BuilderSupplier()
                .supplierName("X-Factor")
                .supplierAddress(address)
                .build();

        Supplier insertedEntity = repo.save(createEntity);
        id = insertedEntity.getSupplierID();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Supplier>suppliers = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",suppliers.size()>0);


        //READ ENTITY
        Supplier entity = repo.findByid(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);


        //UPDATE ENTITY
        Supplier updateEntity = new Supplier.BuilderSupplier()
                .copy(entity)
                .supplierName("Conway")
                .build();
        repo.update(updateEntity);
        Supplier newEntity = repo.findByid(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Conway", newEntity.getSupplierName());


        //Delete ENTITY
        repo.delete(updateEntity);
        Supplier deletedEntity = repo.findByid(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        //Delete All
        repo.deleteAll();





    }
}
