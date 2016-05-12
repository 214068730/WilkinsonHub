package runningshop.assignment7.factories.shop;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Supplier;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class SupplierFactory {
    public static Supplier getSupplier(Long supplierID,String supplierName,AddressVO address){
        return new Supplier.BuilderSupplier()
                .supplierID(supplierID)
                .supplierName(supplierName)
                .supplierAddress(address)
                .build();
    }
}
