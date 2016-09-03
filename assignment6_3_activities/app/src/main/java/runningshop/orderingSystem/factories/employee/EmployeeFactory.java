package runningshop.orderingSystem.factories.employee;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.employee.Employee;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class EmployeeFactory {
    public static Employee getEmployee(Long empCode,String name,String surname,AddressVO address){
        return new Employee.EmployeeBuilder()
                .employeeCode(empCode)
                .name(name)
                .surname(surname)
                .address(address)
                .build();
    }

}
