package runningshop.orderingSystem.domain.account;

import java.io.Serializable;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccount implements Serializable {
    String username;
    String password;

    public EmployeeAccount(EmployeeAccountBuidlder account){
        this.username = account.username;
        this.password = account.password;

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static class EmployeeAccountBuidlder{
        String username;
        String password;

        public EmployeeAccountBuidlder username(String username){
            this.username = username;
            return this;
        }

        public EmployeeAccountBuidlder password(String password){
            this.password = password;
            return this;
        }

        public EmployeeAccountBuidlder copy(EmployeeAccount employee){
            this.username = employee.username;
            this.password = employee.password;
            return this;
        }

        public EmployeeAccount build(){
            return new EmployeeAccount(this);
        }

    }

}
