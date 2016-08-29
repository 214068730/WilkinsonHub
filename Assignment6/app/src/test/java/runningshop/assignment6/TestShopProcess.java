package runningshop.assignment6;

import org.junit.Test;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.customer.Customer;
import runningshop.assignment6.domain.employee.Employee;
import runningshop.assignment6.domain.shop.Item;
import runningshop.assignment6.domain.shop.ShopProcess;
import runningshop.assignment6.factories.customer.CustomerAddressFactory;
import runningshop.assignment6.factories.customer.CustomerFactory;
import runningshop.assignment6.factories.employee.EmployeeAddressFactory;
import runningshop.assignment6.factories.employee.EmployeeFactory;
import runningshop.assignment6.factories.shop.ItemFactory;
import runningshop.assignment6.factories.shop.ProcessFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestShopProcess {
    @Test
    public void testShopProcess() throws Exception {

        //Customer
        AddressVO customerAddress = CustomerAddressFactory.getCustomerAddress("7798", "15 Sparrow", "Rocklands");
        Customer customer = CustomerFactory.getCustomer("001", "Shireen", customerAddress);

        //Employee
        AddressVO employeeAddress = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee("E001", "Kashiefa", "Cottle", employeeAddress);

        //Item'
        Item item1 = ItemFactory.getItem("I001", "Chocolate");
        Item item2 = ItemFactory.getItem("I002", "Bread");
        Item item3 = ItemFactory.getItem("I003", "Milk");

        ShopProcess process = ProcessFactory.startProcess(customer,employee);

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
        Customer customer = CustomerFactory.getCustomer("001", "Shireen", customerAddress);

        //Employee
        AddressVO employeeAddress = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee("E001", "Kashiefa", "Cottle", employeeAddress);

        //Item'
        Item item1 = ItemFactory.getItem("I001", "Chocolate");
        Item item2 = ItemFactory.getItem("I002", "Bread");
        Item item3 = ItemFactory.getItem("I003", "Milk");

        ShopProcess process = ProcessFactory.startProcess(customer,employee);

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
