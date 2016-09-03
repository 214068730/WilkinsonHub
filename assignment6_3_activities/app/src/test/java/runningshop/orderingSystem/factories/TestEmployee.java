package runningshop.orderingSystem.factories;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.employee.Employee;
import runningshop.orderingSystem.factories.employee.EmployeeAddressFactory;
import runningshop.orderingSystem.factories.employee.EmployeeFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestEmployee {
    @Test
    public void testCreateEmployee() throws Exception {
        AddressVO address = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", address);

        employee.employeesHistory(0001L);
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        AddressVO address = EmployeeAddressFactory.getEmployeeAddress("1785","57 Spitz Way","Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", address);

        Employee newEmployee = new Employee.EmployeeBuilder()
                .copy(employee)
                .name("Asheeqah")
                .build();
        Assert.assertEquals(newEmployee.getName(),"Asheeqah");
        Assert.assertEquals(newEmployee.getAddress(),employee.getAddress());
    }



}
