package com.question3;

import com.question3.domain.Car;
import com.question3.services.CarInfo;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/13.
 */
public class TestCars {
    private CarInfo car;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx =  new AnnotationConfigApplicationContext(AppConfig.class);
        car = (CarInfo)ctx.getBean("Bmw");
    }

    @Test
    public void testName() throws Exception {
        Car vehicle= car.getCarInfo();
        Assert.assertEquals(vehicle.getName(),"M3");

    }

    @Test
    public void testPower() throws Exception {
        Car vehicle = car.getCarInfo();
        Assert.assertEquals(vehicle.getCarPower(),320);


    }
}
