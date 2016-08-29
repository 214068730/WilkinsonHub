package runningshop.assignment7.services.customer.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.assignment7.services.customer.CustomerService;

/**
 * Created by Siraaj on 05/07/2016.
 */
public class CustomerServiceImpl extends IntentService implements CustomerService {

    private final CustomerRepository repository;
    private static  CustomerServiceImpl service = null;


    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE="package runningshop.assignment7.services.customer.Impl.action.Update";

    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";


    public CustomerServiceImpl() {
        super("CustomerServiceImpl");
        repository = new CustomerRepositoryImpl(App.getAppContext());
    }

    public static CustomerServiceImpl getInstance(){
        if(service == null)
            service = new CustomerServiceImpl();
        return service;
    }



    @Override
    public void addCustomer(Context context, Customer customer) {
        Intent intent = new Intent(context,CustomerServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,customer);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Customer customerResources = (Customer) intent.getSerializableExtra(EXTRA_ADD);
            Customer customer = new Customer.CustomerBuild()
                    .custCode(customerResources.getCustomerCode())
                    .custName(customerResources.getCustName())
                    .address(customerResources.getAddress())
                    .build();
            repository.save(customer);
            Toast.makeText(getApplicationContext(), "Customer has been added", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
