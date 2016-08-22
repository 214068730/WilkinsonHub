package droid_backend.api;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.Item;
import droid_backend.domain.shop.Shop;
import droid_backend.domain.shop.ShopProcess;
import droid_backend.factory.ItemFactory;
import droid_backend.factory.ProcessFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrdersControllerTest extends AbstractTestNGSpringContextTests {
    @Test
    public void testCreate(){
        String URI = "http://localhost:8080/shop/sales/create";
            RestTemplate restTemplate = new RestTemplate();
            Item item = ItemFactory.getItem(5L,"",50.00);
            //opProcess process = ProcessFactory.startProcess(0L,Integer.parseInt(1L+""),Integer.parseInt(5L+""), item);
            ShopProcess process = new ShopProcess.BuildProcess()
                    .orderNo(0L)
                    .customer(5)
                    .employee(1)
                    .date()
                    .build();
            restTemplate.postForObject(URI,process,ShopProcess.class);
//           Assert.assertEquals(order.getCustomerID(),new Long(1));
        }


}
