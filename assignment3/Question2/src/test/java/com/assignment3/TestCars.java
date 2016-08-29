package com.assignment3;

import com.assignment3.services.Impl.Bmw;
import com.assignment3.services.Impl.Ford;
import com.assignment3.domain.Car;
import com.assignment3.services.CarInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/03/12.
 */
public class TestCars {

    @Before
    public void setUp() throws Exception {
        System.out.println("Testing");

    }

    @Test
    public void testCarPower() throws Exception {
        CarInfo car = new Bmw();
        Car c = car.getCarInfo();
        Assert.assertEquals(c.getCarPower(),320);
    }

    @Test
    public void testCarName() throws Exception {
         CarInfo ford = new Ford();
         Car car = ford.getCarInfo();
         Assert.assertEquals(car.getName(),"Serria XR8");
    }

    @Test
    public void testCarRegistration() throws Exception {
        CarInfo bmw = new Bmw();
        Car car = bmw.getCarInfo();
        Assert.assertEquals(car.getCarID(),"siKash");
    }
}
