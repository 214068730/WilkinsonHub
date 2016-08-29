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
    private static final String ACTION_DELETE="package runningshop.assignment7.services.customer.Impl.action.Delete";

    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "package runningshop.assignment7.services.customer.Impl.extra.Update";
    private static final String EXTRA_DELETE = "package runningshop.assignment7.services.customer.Impl.extra.Delete";


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
    public void deleteCustomer(Context context, Customer customer) {
        Intent intent = new Intent(context,CustomerServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        intent.putExtra(EXTRA_DELETE,customer);
        context.startService(intent);
    }

    @Override
    public void updateCustomer(Context context, Customer customer) {
        Intent intent = new Intent(context,CustomerServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE,customer);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null) {
            final String action = intent.getAction();
            if(ACTION_ADD.equals(action)) {
                    Customer customerResources = (Customer) intent.getSerializableExtra(EXTRA_ADD);
                    add(customerResources);
            }
            else
                if(ACTION_UPDATE.equals(action)){
                    Customer updateCustomer = (Customer)intent.getSerializableExtra(EXTRA_UPDATE);
                    update(updateCustomer);
                }
            else
                if(ACTION_DELETE.equals(action)){
                        Customer deleteCustomer = (Customer)intent.getSerializableExtra(EXTRA_DELETE);
                        delete(deleteCustomer);
                }
        }
    }

    private void update(Customer customer){
        try{
            repository.update(customer);
            Toast.makeText(getApplicationContext(), "Customer has been updated", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void delete(Customer customer){
        try{
            repository.delete(customer);
            Toast.makeText(getApplicationContext(), "Customer has been delete", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void add(Customer customer){
        try{
            Customer addCustomer = new Customer.CustomerBuild()
                    .custCode(customer.getCustomerCode())
                    .custName(customer.getCustName())
                    .address(customer.getAddress())
                    .build();
            repository.save(addCustomer);
            Toast.makeText(getApplicationContext(), "Customer has been add", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
