package runningshop.assignment7.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;

/**
 * Created by Siraaj on 04/22/2016.
 */
public class CustomerRepositoryTest extends AndroidTestCase{
    public static final String TAG = "CUSTOMER TEST";
    private Long id;

    public void testcreateUpdateDelete() throws Exception {
        CustomerRepository repo = new CustomerRepositoryImpl(this.getContext());


        //create address
        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow Road")
                .suburb("Mitchell's plain")
                .build();

        //Create object
        Customer createEntity = new Customer.CustomerBuild()
                .custName("Shireen")
                .address(address)
                .build();

        //write object to database
        Customer insertedEntity = repo.save(createEntity);
        id = insertedEntity.getCustomerCode();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Customer> customers = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", customers.size() > 0);

        //READ ENTITY
        Customer entity = repo.findByid(id);
        Assert.assertNotNull(TAG+" READ ENTITY", entity);

        //UPDATE ENTITY
        Customer updateEntity = new Customer.CustomerBuild()
                .copy(entity)
                .custName("Kashiefa")
                .build();
        repo.update(updateEntity);
        Customer newEntity  = repo.findByid(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Kashiefa",updateEntity.getCustName());


        //DELETE ENTITY
        repo.delete(updateEntity);
        Customer deletedEntity = repo.findByid(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        //Detele All
        repo.deleteAll();
    }

}
