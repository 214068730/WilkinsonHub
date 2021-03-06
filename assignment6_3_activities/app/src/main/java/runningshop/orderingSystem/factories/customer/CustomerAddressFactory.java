package runningshop.orderingSystem.factories.customer;

import runningshop.orderingSystem.domain.address.AddressVO;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class CustomerAddressFactory {
    public static AddressVO getCustomerAddress(String postalCode,String streetName,String suburb){
        return new AddressVO.AddressBuilder()
                .postalCode(postalCode)
                .streetName(streetName)
                .suburb(suburb)
                .build();
    }

}
