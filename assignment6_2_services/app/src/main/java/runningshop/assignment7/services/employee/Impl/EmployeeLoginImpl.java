package runningshop.assignment7.services.employee.Impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.sql.SQLException;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.account.EmployeeAccount;
import runningshop.assignment7.repository.employee.EmployeeAccountRepository;
import runningshop.assignment7.repository.employee.Impl.EmployeeAccountRepositoryImpl;
import runningshop.assignment7.services.employee.EmployeeLogin;

public class EmployeeLoginImpl extends Service implements EmployeeLogin {

    final private EmployeeAccountRepository repo;
    private static EmployeeLoginImpl service = null;

    public static EmployeeLoginImpl getInstance(){
        if(service == null)
            service = new EmployeeLoginImpl();
        return service;
    }

    private final IBinder localBinder = new AccountServiceLocalBinder();


    public EmployeeLoginImpl(){
        repo = new EmployeeAccountRepositoryImpl(App.getAppContext());
    }


    @Override
    public String activateAccount(String username, String password) {
        String account ="NOT ACTIVATED";
       if(!username.equals(null)&& !password.equals(null)) {
           EmployeeAccount employeeAccount = new EmployeeAccount.EmployeeAccountBuidlder()
                   .username(username)
                   .password(password)
                   .build();
           repo.save(employeeAccount);
           return "ACTIVATED";
       }else{
            return account;
       }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }


    public class AccountServiceLocalBinder extends Binder {
        public EmployeeLoginImpl getService(){

            return EmployeeLoginImpl.this;
        }
    }
}
