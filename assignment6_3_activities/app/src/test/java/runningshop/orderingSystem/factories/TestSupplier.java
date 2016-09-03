package runningshop.orderingSystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Supplier;
import runningshop.orderingSystem.factories.shop.SupplierAddressFactory;
import runningshop.orderingSystem.factories.shop.SupplierFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestSupplier {
    @Test
    public void testCreateSupplier() throws Exception {
        AddressVO supplierAddress = SupplierAddressFactory.getSupplierAddress("7785","Church Road","Westridge");
        Supplier supplier = SupplierFactory.getSupplier(01L,"Camen",supplierAddress);

        Assert.assertEquals(supplier.getSupplierName(),"Camen");
        supplier.viewSupplierHistory(01L);
    }

    @Test
    public void testSupplierUpdate() throws Exception {
        AddressVO supplierAddress = SupplierAddressFactory.getSupplierAddress("7785","Church Road","Westridge");
        Supplier supplier = SupplierFactory.getSupplier(01L, "Camen", supplierAddress);

        //Update supplier address
        AddressVO supplierAddressUpdate = SupplierAddressFactory.getSupplierAddress("7798", "15 Sparrow Road", "Rocklands");
        Supplier supplierUpdate = SupplierFactory.getSupplier(01L, "Shireen", supplierAddress);

        Assert.assertEquals(supplierUpdate.getSupplierName(),"Shireen");
        Assert.assertEquals(supplier.getSupplierID(),supplierUpdate.getSupplierID());
        supplierUpdate.viewSupplier();
    }
}
