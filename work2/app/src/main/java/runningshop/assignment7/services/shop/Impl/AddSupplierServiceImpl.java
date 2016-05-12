package runningshop.assignment7.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.AddSupplierService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddSupplierServiceImpl extends IntentService implements AddSupplierService {


    private final SupplierRepository repository;
    private static AddSupplierServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";

    public AddSupplierServiceImpl() {
        super("AddSupplierServiceImpl");
        repository = new SupplierRepositoryImpl(App.getAppContext());
    }


    public static AddSupplierServiceImpl getInstance(){
         if(service == null)
             service = new AddSupplierServiceImpl();
        return service;
    }



    @Override
    public void addService(Context context, Supplier supplier) {
        Intent intent = new Intent(context,AddSupplierServiceImpl.class);
        intent.putExtra(EXTRA_ADD,supplier);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Supplier supplierResources = (Supplier) intent.getSerializableExtra(EXTRA_ADD);
            Supplier supplier = new Supplier.BuilderSupplier()
                    .supplierID(supplierResources.getSupplierID())
                    .supplierName(supplierResources.getSupplierName())
                    .supplierAddress(supplierResources.getSupplierAddress())
                    .build();

            repository.save(supplier);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
