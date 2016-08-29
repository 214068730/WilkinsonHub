package runningshop.assignment7.services.customer;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.assignment7.services.customer.Impl.CustomerDeleteServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 *
 * To use the remove service you have to add to the database fisrt
 */
public class CustomerRemoveServiceTest extends AndroidTestCase {

    public void testRemoveCustomer() throws Exception {

        CustomerRepository repo = new CustomerRepositoryImpl(App.getAppContext());
        CustomerDeleteService customerDeleteService = CustomerDeleteServiceImpl.getInstance();


        //Delete Customer
        Customer client = repo.findByid(1L);
        customerDeleteService.deleteCustomer(App.getAppContext(),client);

        Thread.sleep(1000);
       //Search database for deleted item
        Customer deletedCustomer = repo.findByid(1L);
        Assert.assertNull(deletedCustomer);

      /*//Amount records left in database
      //test will fail
        Set<Customer> customers = repo.findAll();
        int number = customers.size();
        Assert.assertEquals(number,5);*/
    }
}
