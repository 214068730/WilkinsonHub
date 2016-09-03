package runningshop.orderingSystem.services.employee;

import android.content.Context;

import runningshop.orderingSystem.domain.employee.Employee;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface AddEmployeeService {
    void addEmployee(Context context,Employee employee);
    void deleteEmployee(Context context,Employee employee);
    void updateEmployee(Context context,Employee employee);
}
