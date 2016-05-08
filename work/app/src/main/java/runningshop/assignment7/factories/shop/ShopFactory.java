package runningshop.assignment7.factories.shop;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.shop.Shop;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ShopFactory {
    public static Shop getShop(Long shopCode,String shopName,AddressVO address){
        return new Shop.BuildShop()
                .shopID(shopCode)
                .shopName(shopName)
                .address(address)
                .build();
    }

}
