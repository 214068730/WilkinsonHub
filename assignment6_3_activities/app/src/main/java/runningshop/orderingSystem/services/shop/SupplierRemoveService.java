package runningshop.orderingSystem.services.shop;

import android.content.Context;

import runningshop.orderingSystem.domain.shop.Supplier;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface SupplierRemoveService {
    void deleteSupplier(Context context,Supplier supplier);
}
