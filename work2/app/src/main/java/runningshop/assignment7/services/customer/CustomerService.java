package runningshop.assignment7.services.customer;

import android.content.Context;

import runningshop.assignment7.domain.customer.Customer;

/**
 * Created by Siraaj on 05/07/2016.
 */
public interface CustomerService {
    void addCustomer(Context context,Customer customer);
}
