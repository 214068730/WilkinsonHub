package runningshop.assignment7.services.employee.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.repository.employee.EmployeeRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.assignment7.services.employee.EmployeeRemoveService;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class EmployeeRemoveServiceImpl extends IntentService implements EmployeeRemoveService {

    private final EmployeeRepository repo;
    private static EmployeeRemoveServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";

    public EmployeeRemoveServiceImpl() {
        super("EmployeeRemoveServiceImpl");
        repo = new EmployeeRepositoryImpl(App.getAppContext());
    }

    public static EmployeeRemoveServiceImpl getInstance(){
        if(service == null)
            service = new EmployeeRemoveServiceImpl();
        return service;
    }
    @Override
    public void deleteEmployee(Context context, Employee employee) {
        Intent intent = new Intent(context,EmployeeRemoveServiceImpl.class);
        intent.putExtra(EXTRA_ADD, employee);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Employee employeeResource = (Employee) intent.getSerializableExtra(EXTRA_ADD);
            repo.delete(employeeResource);
            Toast.makeText(getApplicationContext(), "Customer removed", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
