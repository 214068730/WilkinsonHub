package runningshop.orderingSystem.services.customer;

import android.content.Context;

import runningshop.orderingSystem.domain.customer.Customer;

/**
 * Created by Siraaj on 05/07/2016.
 */
public interface CustomerService {
    void addCustomer(Context context,Customer customer);
    void deleteCustomer(Context context,Customer customer);
    void updateCustomer(Context context,Customer customer);
    Customer findCustomer(Context context,Long customer);

}
