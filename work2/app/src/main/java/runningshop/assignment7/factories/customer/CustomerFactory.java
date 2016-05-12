package runningshop.assignment7.factories.customer;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class CustomerFactory {
    public static Customer getCustomer(Long custCode,String custName,AddressVO address){
        return new Customer.CustomerBuild()
                .custCode(custCode)
                .custName(custName)
                .address(address)
                .build();
    }

}
