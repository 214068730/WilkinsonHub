package runningshop.assignment7.services.customer;

import android.content.Context;

import runningshop.assignment7.domain.customer.Customer;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface CustomerDeleteService {
    void deleteCustomer(Context context,Customer customer);
}
