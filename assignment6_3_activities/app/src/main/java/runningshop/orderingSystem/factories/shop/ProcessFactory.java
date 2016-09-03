package runningshop.orderingSystem.factories.shop;

import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.domain.employee.Employee;
import runningshop.orderingSystem.domain.shop.ShopProcess;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class ProcessFactory {
    public static ShopProcess startProcess(Long orderNo,Customer customer,Employee employee ){
        return new ShopProcess.BuildProcess().orderNo(orderNo).customer(customer).employee(employee).build();
    }
}
