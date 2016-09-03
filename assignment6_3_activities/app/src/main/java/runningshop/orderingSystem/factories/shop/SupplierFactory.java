package runningshop.orderingSystem.factories.shop;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Supplier;

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
