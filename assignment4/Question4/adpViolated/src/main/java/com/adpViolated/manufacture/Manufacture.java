package com.adpViolated.manufacture;

import com.adpViolated.car.Car;

/**
 * Created by student on 2016/03/27.
 */
public class Manufacture {
    Car car;

    public void createCar(Car car) {
        this.car = car;
    }

    public void displayDetails() {
        System.out.println(car.toString());
    }
}
