package runningshop.orderingSystem.services.employee.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.employee.Employee;
import runningshop.orderingSystem.repository.employee.EmployeeRepository;
import runningshop.orderingSystem.repository.employee.Impl.EmployeeRepositoryImpl;
import runningshop.orderingSystem.services.employee.AddEmployeeService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddEmployeeServiceImpl extends IntentService implements AddEmployeeService {

    private final EmployeeRepository repo;
    private static AddEmployeeServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE ="package runningshop.assignment7.services.customer.Impl.action.UPDATE";
    private static final String ACTION_DELETE ="package runningshop.assignment7.services.customer.Impl.action.DELETE";

    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "package runningshop.assignment7.services.customer.Impl.extra.UPDATE";
    private static final String EXTRA_DELETE = "package runningshop.assignment7.services.customer.Impl.extra.DELETE";


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
    public void deleteEmployee(Context context, Employee employee) {
        Intent intent = new Intent(context,AddEmployeeServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        intent.putExtra(EXTRA_DELETE, employee);
        context.startService(intent);
    }

    @Override
    public void updateEmployee(Context context, Employee employee) {
        Intent intent = new Intent(context,AddEmployeeServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, employee);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
       if(intent != null) {
           final String action =  intent.getAction();
           if(ACTION_ADD.equals(action)) {
               Employee addEmployee = (Employee) intent.getSerializableExtra(EXTRA_ADD);
               add(addEmployee);
           }
           else
                if(ACTION_UPDATE.equals(action)){
                    Employee updateEmployee = (Employee) intent.getSerializableExtra(EXTRA_UPDATE);
                    update(updateEmployee);

                }
           else
                if(ACTION_DELETE.equals(action)){
                    Employee deleteEmployee = (Employee) intent.getSerializableExtra(EXTRA_DELETE);
                    delete(deleteEmployee);
                }
       }

    }

    private void delete(Employee employee){
        try{
            repo.delete(employee);
            Toast.makeText(App.getAppContext(), "Employee has been removed", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void update(Employee employee){
        try{
            repo.update(employee);
            Toast.makeText(App.getAppContext(), "Employee has been updated", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void add(Employee employee){
        try {
            Employee addEmployee = new Employee.EmployeeBuilder()
                    .name(employee.getName())
                    .surname(employee.getSurname())
                    .address(employee.getAddress())
                    .build();
            repo.save(addEmployee);
            Toast.makeText(App.getAppContext(), "Employee added", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
