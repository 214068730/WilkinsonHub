package runningshop.assignment7.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import runningshop.assignment7.domain.account.EmployeeAccount;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeAccountRepository;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeAccountRepositoryImpl;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccountRepositoryTest  extends AndroidTestCase{
    private static final String TAG="EMPLOYEE ACCOUNT TEST";
    String username;

    public void testCreateReadUpdateDelete() throws Exception {
        EmployeeAccountRepository repository = new EmployeeAccountRepositoryImpl(this.getContext());

        EmployeeAccount employeeAccount = new EmployeeAccount.EmployeeAccountBuidlder()
                .username("21068730")
                .password("Kashiefa95!")
                .build();
        EmployeeAccount insertedEntity = repository.save(employeeAccount);
        username = insertedEntity.getUsername();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<EmployeeAccount> employees = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", employees.size() > 0);

        //READ ENTITY
        EmployeeAccount  entity = repository.findByid(username);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);


        //UPDATE
        EmployeeAccount updateEntity = new EmployeeAccount.EmployeeAccountBuidlder()
                .copy(entity)
                .password("kashiefa")
                .build();
        repository.update(updateEntity);
        EmployeeAccount newEntity = repository.findByid(username);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","kashiefa",newEntity.getPassword());


        // DELETE ENTITY
        repository.delete(updateEntity);
        EmployeeAccount deletedEntity = repository.findByid(username);
        Assert.assertNull(TAG + " DELETE", deletedEntity);

        //Delete All
        repository.deleteAll();




    }
}
