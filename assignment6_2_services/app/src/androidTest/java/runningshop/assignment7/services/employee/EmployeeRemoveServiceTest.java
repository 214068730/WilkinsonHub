package runningshop.assignment7.services.employee;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.Impl.EmployeeRemoveServiceImpl;

/**
 * Created by Siraaj on 05/08/2016.
 *
 * To use the remove service you have to add to the database first
 */
public class EmployeeRemoveServiceTest extends AndroidTestCase {
    public void testRemoveEmployee() throws Exception {

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(App.getAppContext());
        EmployeeRemoveService employeeService = EmployeeRemoveServiceImpl.getInstance();

        //find employee in database
        Employee employee = employeeRepository.findByid(1L);

        //service that deletes employee from database
        employeeService.deleteEmployee(App.getAppContext(), employee);

        Thread.sleep(1000);
        Employee deletedEmployee = employeeRepository.findByid(1L);
        Assert.assertNull(deletedEmployee);

      /*  //check that database is decrease
        Set<Employee> employees = employeeRepository.findAll();
        Assert.assertEquals(employees.size(),7);*/
    }
}
