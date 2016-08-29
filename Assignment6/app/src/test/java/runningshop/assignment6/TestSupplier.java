package runningshop.assignment6;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.shop.Supplier;
import runningshop.assignment6.factories.shop.SupplierAddressFactory;
import runningshop.assignment6.factories.shop.SupplierFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestSupplier {
    @Test
    public void testCreateSupplier() throws Exception {
        AddressVO supplierAddress = SupplierAddressFactory.getSupplierAddress("7785","Church Road","Westridge");
        Supplier supplier = SupplierFactory.getSupplier("S001","Camen",supplierAddress);

        Assert.assertEquals(supplier.getSupplierName(),"Camen");
        supplier.viewSupplierHistory("S001");
    }

    @Test
    public void testSupplierUpdate() throws Exception {
        AddressVO supplierAddress = SupplierAddressFactory.getSupplierAddress("7785","Church Road","Westridge");
        Supplier supplier = SupplierFactory.getSupplier("S001","Camen",supplierAddress);

        //Update supplier address
        AddressVO supplierAddressUpdate = SupplierAddressFactory.getSupplierAddress("7798","15 Sparrow Road","Rocklands");
        Supplier supplierUpdate = SupplierFactory.getSupplier("S001", "Shireen", supplierAddress);

        Assert.assertEquals(supplierUpdate.getSupplierName(),"Shireen");
        Assert.assertEquals(supplier.getSupplierID(),supplierUpdate.getSupplierID());
        supplierUpdate.viewSupplier();


    }
}
