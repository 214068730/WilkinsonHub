package com.adpNotViolated.service;

import com.adpNotViolated.car.Car;
import com.adpNotViolated.vehicle.IVehicle;

/**
 * Created by student on 2016/03/27.
 */
public class Honda implements IVehicle {
    Car honda ;

    public Honda() {
        honda = new Car("S2000","siKash",300);
    }

    public void displayCar() {
        System.out.println(honda.toString());
    }

    public Car getCarInfo() {
        return honda;
    }
}
