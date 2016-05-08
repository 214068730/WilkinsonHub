package runningshop.assignment7.Services;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.io.Serializable;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.Impl.AddEmployeeServiceImpl;
import runningshop.assignment7.services.employee.Impl.EmployeeLoginImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAddServiceTest extends AndroidTestCase {

    Intent intent;
    @Override
    public void setUp() throws Exception {
        super.setUp();
         intent = new Intent(App.getAppContext(),AddEmployeeServiceImpl.class);
    }

    public void testAddEmployee() throws Exception {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(this.getContext());
        Long id;
        AddEmployeeServiceImpl employeeService = AddEmployeeServiceImpl.getInstance();


        AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7798")
                .streetName("Sparrow")
                .suburb("Plan")
                .build();

        Employee employee = new Employee.EmployeeBuilder()
                .name("Siraaj")
                .surname("Wilkinson")
                .address(address)
                .build();

        employeeService.addEmployee(App.getAppContext(),employee);
        Assert.assertNotNull("CREATE",employee);
    }
}
