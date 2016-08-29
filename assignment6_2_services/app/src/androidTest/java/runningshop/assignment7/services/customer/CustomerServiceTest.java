package runningshop.assignment7.services.customer;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.assignment7.services.customer.Impl.CustomerServiceImpl;

/**
 * Created by Siraaj on 05/07/2016.
 */
public class CustomerServiceTest extends AndroidTestCase{
    //private CustomerServiceImpl customerService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAddCustomerService() throws Exception {

        CustomerRepository repo = new CustomerRepositoryImpl(App.getAppContext());
        CustomerService cust = CustomerServiceImpl.getInstance();


        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow")
                .suburb("Plan")
                .build();

        Customer customer = new Customer.CustomerBuild()
                .custName("Siraaj")
                .address(address)
                .build();

        Assert.assertNotNull("CREATE", customer);

        //run service adds Customer to database
        cust.addCustomer(App.getAppContext(), customer);

        Thread.sleep(1000);
        Customer insertedCustomer = repo.findByid(1L);
        Assert.assertNotNull(insertedCustomer);
       /* //Enable to see database records increase
        //test will fill if enables
        Set<Customer> customers = repo.findAll();
        Assert.assertEquals(customers.size(),5);*/
    }
}
