package dipNotViolated;

import dipNotViolated.domain.Car;
import dipNotViolated.domain.Manufacture;
import dipNotViolated.service.Impl.Honda;
import dipNotViolated.service.Impl.Nissan;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/22.
 */
public class TestCar {
    Honda honda;
    Nissan nissan;
    Manufacture manufacture;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        honda = (Honda)ctx.getBean("Honda");
        nissan = (Nissan)ctx.getBean("Nissan");
        manufacture=(Manufacture) ctx.getBean("Manufacture");
    }

    @Test
    public void testDetails() throws Exception {
            Car carHonda = honda.getCarInfo();
            Car carNissan = nissan.getCarInfo();
            Assert.assertEquals(carHonda.getName(),"S2000");
            Assert.assertEquals(carNissan.getName(),"Sti");
    }

    @Test
    public void testPower() throws Exception {
        Car carHonda = honda.getCarInfo();
        Car carNissan = nissan.getCarInfo();
        Assert.assertTrue(carHonda.getPower()>carNissan.getPower());
    }

    @Test
    public void testManufacture() throws Exception {
        manufacture.createCar(new Nissan());
        manufacture.display();
    }
}
