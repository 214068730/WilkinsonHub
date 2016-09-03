package runningshop.orderingSystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.shop.Shop;
import runningshop.orderingSystem.factories.shop.ShopAddressFactory;
import runningshop.orderingSystem.factories.shop.ShopFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestShop {
    @Test
    public void testCreateShop() throws Exception {
        AddressVO shopAddress = ShopAddressFactory.getShopAddress("7798","15 Sparrow Road","Rocklands");
        Shop shop = ShopFactory.getShop(10L, "Bev's Trendy Shop", shopAddress);

        Assert.assertEquals(shop.getShopName(),"Bev's Trendy Shop");
        shop.viewShop();
    }

    @Test
    public void testShopUpdate() throws Exception {
        AddressVO shopAddress = ShopAddressFactory.getShopAddress("7798","15 Sparrow Road","Rocklands");
        Shop shop = ShopFactory.getShop(10L, "Bev's Trendy Shop", shopAddress);

        AddressVO shopAddressUpdate = ShopAddressFactory.getShopAddress("7798", "57 Spitz way", "Stranfontein");
        Shop shopUpdate = new Shop.BuildShop().copy(shop).address(shopAddressUpdate).build();

        Assert.assertEquals(shopUpdate.getAddress(),shopAddressUpdate);
        Assert.assertEquals(shopUpdate.getShopName(),shop.getShopName());
        Assert.assertEquals(shopUpdate.getShopID(),shop.getShopID());
        shopUpdate.viewShop();

    }
}
