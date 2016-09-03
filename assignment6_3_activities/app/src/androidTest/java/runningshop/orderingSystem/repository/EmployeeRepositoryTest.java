package runningshop.orderingSystem.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.employee.Employee;
import runningshop.orderingSystem.repository.employee.EmployeeRepository;
import runningshop.orderingSystem.repository.employee.Impl.EmployeeRepositoryImpl;

/**
 * Created by Siraaj on 04/22/2016.
 */
public class EmployeeRepositoryTest extends AndroidTestCase {
    private static final String TAG="EMPLOYEE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        EmployeeRepository repo = new EmployeeRepositoryImpl(this.getContext());

        //Create
       AddressVO address = new AddressVO.AddressBuilder()
                .postalCode("7785")
                .streetName("Spitz Way")
                .suburb("Strandfontien")
                .build();

        Employee createEntity = new Employee.EmployeeBuilder()
                .name("Shireen")
                .surname("Wilkinson")
                .address(address)
                .build();

        Employee insertedEntity = repo.save(createEntity);
        id = insertedEntity.getEmpCode();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Employee> employees = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", employees.size() > 0);

        //READ ENTITY
        Employee entity = repo.findByid(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE
        Employee updateEntity = new Employee.EmployeeBuilder()
                .copy(entity)
                .name("Shahiem")
                .surname("Wilkinson")
                .build();
        repo.update(updateEntity);
        Employee newEntity = repo.findByid(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Shahiem",newEntity.getName());
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Wilkinson", newEntity.getSurname());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Employee deletedEntity = repo.findByid(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

        //Delete All
        repo.deleteAll();


    }
}
