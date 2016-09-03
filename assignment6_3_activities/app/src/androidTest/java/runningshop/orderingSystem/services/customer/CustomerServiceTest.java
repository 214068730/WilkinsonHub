package runningshop.orderingSystem.services.customer;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.repository.customer.CustomerRepository;
import runningshop.orderingSystem.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.orderingSystem.services.customer.Impl.CustomerServiceImpl;

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
      //  Assert.assertNotNull(insertedCustomer);

        //update
/*        Customer updateCustomer = new Customer.CustomerBuild()
                .copy(insertedCustomer)
                .custName("Kashiefa")
                .build();
        cust.updateCustomer(App.getAppContext(), updateCustomer);
        Thread.sleep(1000);
        Customer updatedCustomer = repo.findByid(1L);
        Assert.assertEquals(updatedCustomer.getCustName(), "Kashiefa");

        //delete
        cust.deleteCustomer(App.getAppContext(),updatedCustomer);
        Thread.sleep(1000);
        Customer deletedCustomer = repo.findByid(1L);
        Assert.assertNull(deletedCustomer);

       /* //Enable to see database records increase
        //test will fill if enables
        Set<Customer> customers = repo.findAll();
        Assert.assertEquals(customers.size(),5);*/
    }

}
