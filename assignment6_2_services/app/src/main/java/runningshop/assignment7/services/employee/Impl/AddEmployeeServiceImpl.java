package runningshop.assignment7.services.employee.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.io.Serializable;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.AddEmployeeService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddEmployeeServiceImpl extends IntentService implements AddEmployeeService {

    private final EmployeeRepository repo;
    private static AddEmployeeServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";


    public static AddEmployeeServiceImpl getInstance(){
        if(service == null)
            service = new AddEmployeeServiceImpl();
        return service;
    }

    public AddEmployeeServiceImpl() {
        super("AddEmployeeServiceImpl");
        repo = new EmployeeRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addEmployee(Context context, Employee employee) {
        Intent intent = new Intent(context,AddEmployeeServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, employee);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Employee employeeResource = (Employee) intent.getSerializableExtra(EXTRA_ADD);
            Employee employee = new Employee.EmployeeBuilder()
                    // .employeeCode(employeeResource.getEmpCode())
                    .name(employeeResource.getName())
                    .surname(employeeResource.getSurname())
                    .address(employeeResource.getAddress())
                    .build();
            repo.save(employee);
            Toast.makeText(App.getAppContext(), "Employee added", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
