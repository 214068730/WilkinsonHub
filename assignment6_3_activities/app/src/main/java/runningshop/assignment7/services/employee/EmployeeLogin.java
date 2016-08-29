package runningshop.assignment7.services.employee;

import java.sql.SQLException;

import runningshop.assignment7.domain.account.EmployeeAccount;

/**
 * Created by Siraaj on 05/08/2016.
 */
public interface EmployeeLogin {

    public String activateAccount(String username, String password);
}
