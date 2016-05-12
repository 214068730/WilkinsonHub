package runningshop.assignment7.services.employee;

import android.content.Context;

import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.domain.employee.Employee;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface AddEmployeeService {
    void addEmployee(Context context,Employee employee);
}
