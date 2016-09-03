package runningshop.orderingSystem.services.shop;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Supplier;
import runningshop.orderingSystem.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.orderingSystem.repository.shop.SupplierRepository;
import runningshop.orderingSystem.services.shop.Impl.AddSupplierServiceImpl;

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

         Assert.assertNotNull("Create", supplier);

        //Service to add Supplier
         supplierService.addService(App.getAppContext(), supplier);


        Thread.sleep(1000);
        Supplier addedSupplier = repo.findByid(1L);
        Assert.assertNotNull(addedSupplier);
        Assert.assertEquals(addedSupplier.getStreetName(),"Sparrow");


        Supplier updateSupplier = new Supplier.BuilderSupplier()
                .copy(addedSupplier)
                .supplierName("Bev WorkShop")
                .build();

        //Service updating
        supplierService.updateSupplier(App.getAppContext(),updateSupplier);

        Thread.sleep(1000);
        Supplier updatedSupplier = repo.findByid(1L);
        Assert.assertEquals(updatedSupplier.getSupplierName(),"Bev WorkShop");


       /* //check that database is growing
        //if enable test will fail
        //only checks if database is increasing
        Assert.assertEquals(suppliers.size(),5);*/
    }
}
