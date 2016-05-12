package runningshop.assignment7.services.shop;

import android.content.Context;

import runningshop.assignment7.domain.shop.Supplier;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface SupplierRemoveService {
    void deleteSupplier(Context context,Supplier supplier);
}
