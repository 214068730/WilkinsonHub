package runningshop.orderingSystem.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.shop.Supplier;
import runningshop.orderingSystem.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.orderingSystem.repository.shop.SupplierRepository;
import runningshop.orderingSystem.services.shop.SupplierRemoveService;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class SupplierRemoveServiceImpl extends IntentService implements SupplierRemoveService {

    private final SupplierRepository repository;
    private static SupplierRemoveServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";

    public SupplierRemoveServiceImpl() {
        super("SupplierRemoveServiveImpl");
        repository = new SupplierRepositoryImpl(App.getAppContext());
    }

    public static SupplierRemoveServiceImpl getInstance(){
        if(service == null)
            service = new SupplierRemoveServiceImpl();
        return service;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Supplier supplierResources = (Supplier) intent.getSerializableExtra(EXTRA_ADD);
            repository.delete(supplierResources);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteSupplier(Context context, Supplier supplier) {
        Intent intent = new Intent(context,SupplierRemoveServiceImpl.class);
        intent.putExtra(EXTRA_ADD,supplier);
        context.startService(intent);
    }
}
