package runningshop.assignment6;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.customer.Customer;
import runningshop.assignment6.domain.shop.Item;
import runningshop.assignment6.factories.customer.CustomerAddressFactory;
import runningshop.assignment6.factories.customer.CustomerFactory;
import runningshop.assignment6.factories.shop.ItemFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestCustomer {

    @Test
    public void testCreateCustomer() throws Exception {
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer("001","Shireen",customerAddress);
        customer.viewCustomerAccount("001");

    }

    @Test
    public void testUpdateCustomer() throws Exception {
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer("001", "Shireen", customerAddress);

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
        Customer customer = CustomerFactory.getCustomer("001", "Shireen", customerAddress);
        Item item = ItemFactory.getItem("I001","Juice");

        //Customer rights
        customer.RequestItem("I would like chocolate");
        customer.comment("I like the service of the shop");
        customer.returnItem(item);
    }
}
