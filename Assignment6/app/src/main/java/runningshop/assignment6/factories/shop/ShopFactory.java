package runningshop.assignment6.factories.shop;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.shop.Shop;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ShopFactory {
    public static Shop getShop(String shopCode,String shopName,AddressVO address){
        return new Shop.BuildShop()
                .shopID(shopCode)
                .shopName(shopName)
                .address(address)
                .build();
    }

}
