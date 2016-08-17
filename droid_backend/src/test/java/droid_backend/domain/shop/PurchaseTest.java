package droid_backend.domain.shop;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.Item;
import droid_backend.domain.shop.ShopProcess;
import droid_backend.factory.*;
import junit.framework.TestCase;
import org.junit.Test;


import javax.persistence.Convert;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class PurchaseTest extends TestCase {

    @Test
    public void testCreatePurchaseProcess() throws Exception {
        //Customer
        AddressVO customerAddress = AddressFactory.getAddress("7798", "15 Sparrow", "Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        //Employee
        AddressVO employeeAddress = AddressFactory.getAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);

        //Item'
        Item item1 = ItemFactory.getItem(100L, "Chocolate");
        Item item2 = ItemFactory.getItem(101L, "Bread");
        Item item3 = ItemFactory.getItem(102L, "Milk");

        ShopProcess process = ProcessFactory.startProcess(00001L, customer, employee,item1);
       // Assert.assertEquals(00001L,Integer.parseInt(process.getOrderNo()));
    }
}
