package runningshop.assignment7.factories;

import org.junit.Test;

import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.domain.shop.Item;
import runningshop.assignment7.domain.shop.ShopProcess;
import runningshop.assignment7.factories.customer.CustomerAddressFactory;
import runningshop.assignment7.factories.customer.CustomerFactory;
import runningshop.assignment7.factories.employee.EmployeeAddressFactory;
import runningshop.assignment7.factories.employee.EmployeeFactory;
import runningshop.assignment7.factories.shop.ItemFactory;
import runningshop.assignment7.factories.shop.ProcessFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestShopProcess {
    @Test
    public void testShopProcess() throws Exception {

        //Customer
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798", "15 Sparrow", "Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        //Employee
        AddressVO employeeAddress = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);

        //Item'
        Item item1 = ItemFactory.getItem(100L, "Chocolate");
        Item item2 = ItemFactory.getItem(101L, "Bread");
        Item item3 = ItemFactory.getItem(102L, "Milk");

        ShopProcess process = ProcessFactory.startProcess(00001L, customer, employee);

        process.add(item1);
        process.add(item2);
        process.add(item2);

        process.payMethod("Cash");
        process.collectionType("Self pick up");
        process.printReciept();
    }

    @Test
    public void testTestPrintReceipts() throws Exception {
        //Customer
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798", "15 Sparrow", "Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        //Employee
        AddressVO employeeAddress = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);

        //Item'
        Item item1 = ItemFactory.getItem(100L, "Chocolate");
        Item item2 = ItemFactory.getItem(101L, "Bread");
        Item item3 = ItemFactory.getItem(102L, "Milk");

        ShopProcess process = ProcessFactory.startProcess(00001L, customer, employee);

        process.add(item1);
        process.add(item2);
        process.add(item2);

        process.payMethod("Cash");
        process.collectionType("Self pick up");

        //print receipt
        process.printReciept();

        //print refund
        process.printRefund();

    }
}
