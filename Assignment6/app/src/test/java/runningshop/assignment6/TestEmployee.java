package runningshop.assignment6;

import junit.framework.Assert;

import org.junit.Test;

import runningshop.assignment6.domain.address.AddressVO;
import runningshop.assignment6.domain.employee.Employee;
import runningshop.assignment6.factories.employee.EmployeeAddressFactory;
import runningshop.assignment6.factories.employee.EmployeeFactory;

/**
 * Created by Siraaj on 04/17/2016.
 */
public class TestEmployee {
    @Test
    public void testCreateEmployee() throws Exception {
        AddressVO address = EmployeeAddressFactory.getEmployeeAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee("001", "Kashiefa", "Cottle", address);

        employee.employeesHistory("001");
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        AddressVO address = EmployeeAddressFactory.getEmployeeAddress("1785","57 Spitz Way","Strandfontien");
        Employee employee = EmployeeFactory.getEmployee("E001", "Kashiefa", "Cottle", address);

        Employee newEmployee = new Employee.EmployeeBuilder()
                .copy(employee)
                .name("Asheeqah")
                .build();
        Assert.assertEquals(newEmployee.getName(),"Asheeqah");
        Assert.assertEquals(newEmployee.getAddress(),employee.getAddress());
    }



}
