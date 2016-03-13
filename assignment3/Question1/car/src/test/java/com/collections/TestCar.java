package com.collections;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 2016/03/10.
 */
public class TestCar {

    @Before
    public void setUp() throws Exception {
        Car vehicle = new Car();
    }

    @Test
    public void testCarDetails() throws Exception {

        Car vehicle = new Car("CA55220","Toyota",1989,"16 Valve",100);
        Assert.assertEquals("CA55220",vehicle.getCarNumber());
        Assert.assertEquals("Toyota",vehicle.getCarName());
        Assert.assertEquals(1989,vehicle.getCarModel());
        Assert.assertEquals("16 Valve",vehicle.getCarEngine());
        Assert.assertEquals(100,vehicle.getCarPower());
    }

    @Test
    public void testDisplayCar() throws Exception {

        Car[] vehicle = new Car[2];
      //  Car vehicle = new Car("CA55220","Toyota",1989,"16 Valve",100);
        vehicle[0] = new Car("CA55220","Toyota",1989,"16 Valve",100);
        vehicle[1] = new Car("CA55221","Toyota",1990,"16 Valve",100);




        Set<Car> carList = new HashSet();
        for(int i=0;i<2;i++)
            carList.add(vehicle[i]);

        //adding duplicate object
        carList.add(vehicle[1]);

        System.out.println(carList.toString());
    }
}
