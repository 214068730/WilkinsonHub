package runningshop.assignment7.Services;

import android.app.Activity;
import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.AddSupplierService;
import runningshop.assignment7.services.shop.Impl.AddSupplierServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class SupplierRemoveServiceTest extends AndroidTestCase {
    public void testDeleteSupplier() throws Exception {

        SupplierRepository repo = new SupplierRepositoryImpl(this.getContext());
        Long id;

        Intent intent = new Intent(App.getAppContext(),AddSupplierServiceImpl.class);
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

        //App.getAppContext().startService(intent);
        supplierService.addService(App.getAppContext(),supplier);
        id = supplier.getSupplierID();

        Assert.assertNotNull("Create", supplier);

        //Delete
        repo.delete(supplier);
        Supplier deletedEntity = repo.findByid(id);
        Assert.assertNull(" DELETE", deletedEntity);

    }
}
