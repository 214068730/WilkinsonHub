package runningshop.assignment7.services.shop;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.Impl.AddSupplierServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class SupplierAddServiceTest extends AndroidTestCase {


    public void testAddSupplier() throws Exception {

        SupplierRepository repo = new SupplierRepositoryImpl(this.getContext());
        Long id;
        AddSupplierService supplierService = new AddSupplierServiceImpl();

        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow")
                .suburb("Plan")
                .build();

        Supplier supplier = new Supplier.BuilderSupplier()
                .supplierName("BEv")
                .supplierAddress(address)
                .build();

         Assert.assertNotNull("Create",supplier);

        //Service to add Supplier
         supplierService.addService(App.getAppContext(), supplier);


        Thread.sleep(1000);
        //Check if database is empty
        Set<Supplier> suppliers = repo.findAll();
        Assert.assertTrue(suppliers.size()>0);

       /* //check that database is growing
        //if enable test will fail
        //only checks if database is increasing
        Assert.assertEquals(suppliers.size(),5);*/

        //Check details of added supplier in database
        id = 1L;
        Supplier addedSupplier = repo.findByid(1L);
        Assert.assertNotNull(addedSupplier);
    }
}
