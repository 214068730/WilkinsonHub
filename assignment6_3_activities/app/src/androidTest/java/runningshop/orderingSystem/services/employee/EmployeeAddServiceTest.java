package runningshop.orderingSystem.services.employee;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.employee.Employee;
import runningshop.orderingSystem.repository.employee.EmployeeRepository;
import runningshop.orderingSystem.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.orderingSystem.services.employee.Impl.AddEmployeeServiceImpl;

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

        //service is adding
       employeeService.addEmployee(App.getAppContext(), employee);

        Thread.sleep(1000);
        Employee insertEmployee = employeeRepository.findByid(3L);
        Assert.assertNotNull(insertEmployee);

        Employee updateEmployee = new Employee.EmployeeBuilder()
                .copy(insertEmployee)
                .name("Shireen")
                .build();

        //services updating
        employeeService.updateEmployee(App.getAppContext(),updateEmployee);

        Thread.sleep(1000);
        Employee updatedEmployee = employeeRepository.findByid(3L);
        Assert.assertEquals(updatedEmployee.getName(),"Shireen");

        //services deleting
        employeeService.deleteEmployee(App.getAppContext(), updatedEmployee);

       /* //Checks how many records are in the database
        Set<Employee> employees = employeeRepository.findAll();
        int number= employees.size();
        Assert.assertEquals(number,5);*/
    }
}
