package runningshop.assignment6.factories.shop;

import runningshop.assignment6.domain.customer.Customer;
import runningshop.assignment6.domain.employee.Employee;
import runningshop.assignment6.domain.shop.ShopProcess;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ProcessFactory {
    public static ShopProcess startProcess(Customer customer,Employee employee ){
        return new ShopProcess.BuildProcess().customer(customer).employee(employee).build();
    }
}
