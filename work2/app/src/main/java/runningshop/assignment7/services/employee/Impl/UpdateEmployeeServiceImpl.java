package runningshop.assignment7.services.employee.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.UpdateEmployeeService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class UpdateEmployeeServiceImpl extends IntentService implements UpdateEmployeeService {

    private final EmployeeRepository repository;
    private static UpdateEmployeeServiceImpl service = null;

    private static final String ACTION_UPDATE="package runningshop.assignment7.services.customer.Impl.action.Update";
    private static final String EXTRA_UPDATE = "package runningshop.assignment7.services.customer.Impl.extra.ADD";


    public UpdateEmployeeServiceImpl() {
        super("UpdateEmployeeServiceImpl");
        repository = new EmployeeRepositoryImpl(App.getAppContext());

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final Employee employeeResources =(Employee) intent.getSerializableExtra(EXTRA_UPDATE);
        if(intent != null){
           /* Employee employee = new Employee.EmployeeBuilder()
                    .copy(employeeResources)*/



        }

    }

    @Override
    public void updateEmployee(Context context, Employee employee) {
        Intent intent = new Intent(context,UpdateEmployeeServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, employee);
        context.startService(intent);
    }
}
