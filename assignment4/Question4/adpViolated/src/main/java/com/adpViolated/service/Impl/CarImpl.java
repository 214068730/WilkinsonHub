package com.adpViolated.service.Impl;

import com.adpViolated.car.Car;
import com.adpViolated.service.ICar;

/**
 * Created by student on 2016/03/27.
 */
public class CarImpl implements ICar {

    public Car getCar() {
        Car car = new Car("Toyota","CA546487",120);
        return car;

    }
}
