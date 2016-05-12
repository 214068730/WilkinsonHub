package runningshop.assignment7.Services;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.assignment7.services.customer.CustomerDeleteService;
import runningshop.assignment7.services.customer.CustomerService;
import runningshop.assignment7.services.customer.Impl.CustomerDeleteServiceImpl;
import runningshop.assignment7.services.customer.Impl.CustomerServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class CustomerRemoveServiceTest extends AndroidTestCase {

    public void testRemoveCustomer() throws Exception {

        CustomerRepository repo = new CustomerRepositoryImpl(this.getContext());
        Long id;
        Intent intent = new Intent(App.getAppContext(),CustomerServiceImpl.class);
        CustomerService cust = new CustomerServiceImpl();
        CustomerDeleteService customerDeleteService = new CustomerDeleteServiceImpl();
        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow")
                .suburb("Plan")
                .build();

        Customer customer = new Customer.CustomerBuild()
                .custName("Siraaj")
                .address(address)
                .build();

        cust.addCustomer(App.getAppContext(), customer);
        App.getAppContext().startService(intent);
        id = customer.getCustomerCode();


        Assert.assertNotNull("CREATE", customer);

        //Delete
        repo.delete(customer);
        Customer deletedEntity = repo.findByid(id);
        Assert.assertNull(" DELETE", deletedEntity);
    }
}
