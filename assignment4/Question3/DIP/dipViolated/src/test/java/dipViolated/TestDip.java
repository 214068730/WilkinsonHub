package dipViolated;

import dipViolated.badDipExample.Car;
import dipViolated.badDipExample.Manufacture;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/22.
 */
public class TestDip {

    Car car;
    Manufacture manufacture;

    @Before
    public void setUp() throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        manufacture=(Manufacture) ctx.getBean("manufacture");
        car=(Car)ctx.getBean("car");
    }

    @Test
    public void testDisplay() throws Exception {
        manufacture.createCar(car);
        manufacture.displayDetails();
    }

    @Test
    public void testCarName() throws Exception {
        Assert.assertEquals(car.getPower(),220);
    }
}
