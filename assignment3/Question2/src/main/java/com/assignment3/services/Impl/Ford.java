package com.assignment3.services.Impl;

import com.assignment3.services.CarInfo;
import com.assignment3.domain.Car;

/**
 * Created by student on 2016/03/12.
 */
public class Ford implements CarInfo {

    public Car getCarInfo() {
        Car ford = new Car();
        ford.setName("Serria XR8");
        ford.setCarID("CA1978683");
        ford.setCarPower(500);
        ford.setCarEngine("V8");

        return  ford;
    }

}
