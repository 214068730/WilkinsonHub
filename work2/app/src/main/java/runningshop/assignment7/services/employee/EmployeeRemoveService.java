package runningshop.assignment7.services.employee;

import android.content.ContentValues;
import android.content.Context;

import runningshop.assignment7.domain.employee.Employee;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface EmployeeRemoveService {
    void deleteEmployee(Context context,Employee employee);
}
