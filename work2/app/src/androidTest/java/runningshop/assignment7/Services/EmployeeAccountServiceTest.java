package runningshop.assignment7.Services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.account.EmployeeAccount;
import runningshop.assignment7.domain.employee.Employee;
import runningshop.assignment7.services.employee.Impl.EmployeeLoginImpl;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class EmployeeAccountServiceTest extends AndroidTestCase {

    private EmployeeLoginImpl loginService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(),EmployeeLoginImpl.class);
        App.getAppContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EmployeeLoginImpl.AccountServiceLocalBinder binder = ( EmployeeLoginImpl.AccountServiceLocalBinder)service;
            loginService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

   public void testActivateAccount() throws Exception {
        String account = loginService.activateAccount("214068731", "Siraaj");
        Assert.assertEquals("ACTIVATED",account);

    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = loginService.isAccountActivated();
        Assert.assertTrue("ACTIVATED",activated);

    }


    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = loginService.deactivateAccount();
        Assert.assertTrue("ACTIVATED",deactivated);

    }
}
