package runningshop.assignment7.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.SupplierRemoveService;


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
        Supplier supplierResources = (Supplier) intent.getSerializableExtra(EXTRA_ADD);
        repository.delete(supplierResources);
        
    }

    @Override
    public void deleteSupplier(Context context, Supplier supplier) {
        Intent intent = new Intent(context,SupplierRemoveServiceImpl.class);
        intent.putExtra(EXTRA_ADD,supplier);
        context.startService(intent);
    }
}
