package runningshop.assignment7.factories.employee;

import runningshop.assignment7.domain.account.EmployeeAccount;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccountFactory {
    public static EmployeeAccount getEmployee(String username,String password){
        return new EmployeeAccount.EmployeeAccountBuidlder()
                .username(username)
                .password(password)
                .build();
    }
}
