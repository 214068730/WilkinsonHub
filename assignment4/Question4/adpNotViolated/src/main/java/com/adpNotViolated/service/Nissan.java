package com.adpNotViolated.service;

import com.adpNotViolated.car.Car;
import com.adpNotViolated.vehicle.IVehicle;


/**
 * Created by student on 2016/03/27.
 */
public class Nissan implements IVehicle {
    Car nissan;


    public Nissan() {
        nissan = new Car("Sti","CA4564878",150);
    }

    public Car getCarInfo() {
      // nissan = new Car("Sti","CA4564878",150);
        return nissan;
    }

    public void displayCar() {
        System.out.println(nissan.toString());
    }
}
