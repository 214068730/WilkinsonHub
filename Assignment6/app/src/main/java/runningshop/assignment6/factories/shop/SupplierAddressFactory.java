package runningshop.assignment6.factories.shop;

import runningshop.assignment6.domain.address.AddressVO;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class SupplierAddressFactory {
    public static AddressVO getSupplierAddress(String postalCode,String streetName,String suburb) {

    return new AddressVO.AddressBuilder().
            postalCode(postalCode)
            .streetName(streetName)
            .suburb(suburb)
            .build();
    }
}
