package runningshop.assignment7.services.employee;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.address.AddressVO;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.Impl.AddEmployeeServiceImpl;

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

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(App.getAppContext());
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

        employeeService.addEmployee(App.getAppContext(), employee);

        Thread.sleep(1000);
        Employee insertEmployee = employeeRepository.findByid(1L);
        Assert.assertNotNull(insertEmployee);
      /*//Checks how many records are in the database
        Set<Employee>employees = employeeRepository.findAll();
        int number= employees.size();
        Assert.assertEquals(number,5);*/
    }
}
