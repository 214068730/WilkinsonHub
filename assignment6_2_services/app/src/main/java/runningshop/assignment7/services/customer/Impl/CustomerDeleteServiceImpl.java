package runningshop.assignment7.services.customer.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.assignment7.services.customer.CustomerDeleteService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class CustomerDeleteServiceImpl extends IntentService implements CustomerDeleteService {

    private final CustomerRepository repository;
    private static  CustomerDeleteServiceImpl service = null;


    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE="package runningshop.assignment7.services.customer.Impl.action.Update";

    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";

    public CustomerDeleteServiceImpl() {
        super("CustomerDeleteServiceImpl");
        repository = new CustomerRepositoryImpl(App.getAppContext());
    }

    public static CustomerDeleteServiceImpl getInstance(){
        if(service == null)
            service = new CustomerDeleteServiceImpl();
        return service;
    }

    @Override
    public void deleteCustomer(Context context, Customer customer) {
        Intent intent = new Intent(context,CustomerDeleteServiceImpl.class);
        intent.putExtra(EXTRA_ADD,customer);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Customer customerResources = (Customer) intent.getSerializableExtra(EXTRA_ADD);
            repository.delete(customerResources);
            Toast.makeText(getApplicationContext(), "Customer removed", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
