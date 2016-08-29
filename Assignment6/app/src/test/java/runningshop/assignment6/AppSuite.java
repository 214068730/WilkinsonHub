package runningshop.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Siraaj on 04/17/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCustomer.class,
        TestEmployee.class,
        TestItem.class,
        TestShop.class,
        TestShopProcess.class

})
public class AppSuite {
}
