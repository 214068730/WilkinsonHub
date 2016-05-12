package runningshop.assignment7.Services;

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
public class EmployeeRemoveServiceTest extends AndroidTestCase {
    public void testRemoveEmployee() throws Exception {
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
        id = employee.getEmpCode();
        Assert.assertNotNull("CREATE", employee);


        //delete
        employeeRepository.delete(employee);
        Employee deletedEntity = employeeRepository.findByid(id);
        Assert.assertNull(" DELETE", deletedEntity);

    }
}
