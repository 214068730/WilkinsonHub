package runningshop.assignment7.services.employee;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.repository.employee.EmployeeAccountRepository;
import runningshop.assignment7.services.employee.Impl.EmployeeLoginImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccountServiceTest extends AndroidTestCase {

    private EmployeeLoginImpl loginService;
    private boolean isBound;
    EmployeeAccountRepository repo;
    Context context =getContext();
    Intent intent;


    @Override
    public void setUp() throws Exception {
        super.setUp();

        intent = new Intent(App.getAppContext(),EmployeeLoginImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
       // isBound = true;
    }

    private ServiceConnection connection = new ServiceConnection()  {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EmployeeLoginImpl.AccountServiceLocalBinder binder = ( EmployeeLoginImpl.AccountServiceLocalBinder)service;
            loginService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            loginService = null;
            isBound = false;
        }
    };

   public void testActivateAccount() throws Exception{
       Thread.sleep(1000);
       String account =loginService.activateAccount("2140687300", "Siraaj");
       Assert.assertEquals("ACTIVATED", account);
    }
}
