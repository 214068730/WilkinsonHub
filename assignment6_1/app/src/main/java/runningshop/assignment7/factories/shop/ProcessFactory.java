package runningshop.assignment7.factories.shop;

import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.domain.shop.ShopProcess;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ProcessFactory {
    public static ShopProcess startProcess(Long orderNo,Customer customer,Employee employee ){
        return new ShopProcess.BuildProcess().orderNo(orderNo).customer(customer).employee(employee).build();
    }
}
