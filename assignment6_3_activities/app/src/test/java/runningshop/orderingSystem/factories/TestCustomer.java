package runningshop.orderingSystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.domain.shop.Item;
import runningshop.orderingSystem.factories.customer.CustomerAddressFactory;
import runningshop.orderingSystem.factories.customer.CustomerFactory;
import runningshop.orderingSystem.factories.shop.ItemFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestCustomer {

    @Test
    public void testCreateCustomer() throws Exception {
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);
        customer.viewCustomerAccount(1000L);

    }

    @Test
    public void testUpdateCustomer() throws Exception {
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        Customer newCustomer = new Customer.CustomerBuild()
                .copy(customer)
                .custName("Siraaj")
                .build();

        Assert.assertEquals(newCustomer.getCustName(),"Siraaj");
        Assert.assertEquals(newCustomer.getCustomerCode(),customer.getCustomerCode());
        Assert.assertEquals(newCustomer.getAddress(),customer.getAddress());
    }

    @Test
    public void testCustmerRights() throws Exception {
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);
        Item item = ItemFactory.getItem(100L,"Juice");

        //Customer rights
        customer.RequestItem("I would like chocolate");
        customer.comment("I like the service of the shop");
        customer.returnItem(item);
    }
}
