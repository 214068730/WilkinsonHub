package runningshop.assignment7.services.shop;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.Impl.SupplierRemoveServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 * TO use the remove service you have to add to the database first
 */
public class SupplierRemoveServiceTest extends AndroidTestCase {
    public void testDeleteSupplier() throws Exception {

        SupplierRepository repo = new SupplierRepositoryImpl(App.getAppContext());
        SupplierRemoveService supplierService = SupplierRemoveServiceImpl.getInstance();


        //Get supplier from database
        Supplier supplier = repo.findByid(1L);

        //service to delete supplier
        supplierService.deleteSupplier(App.getAppContext(),supplier);

        Thread.sleep(1000);
        //Delete
        Supplier deletedEntity = repo.findByid(1L);
        Assert.assertNull(deletedEntity);


        Set<Supplier>suppliers = repo.findAll();
        Assert.assertEquals(suppliers.size(),5);

    }
}
