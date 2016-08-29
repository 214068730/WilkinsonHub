package runningshop.assignment6.factories.employee;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.employee.Employee;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class EmployeeFactory {
    public static Employee getEmployee(String empCode,String name,String surname,AddressVO address){
        return new Employee.EmployeeBuilder()
                .employeeCode(empCode)
                .name(name)
                .surname(surname)
                .address(address)
                .build();
    }

}
