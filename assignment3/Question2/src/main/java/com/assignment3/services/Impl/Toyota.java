package com.assignment3.services.Impl;

import com.assignment3.services.CarInfo;
import com.assignment3.domain.Car;

/**
 * Created by student on 2016/03/12.
 */
public class Toyota implements CarInfo {

    public Car getCarInfo() {
       Car toyota = new Car();
        toyota.setName("Corolla twincam");
        toyota.setCarID("CA197998");
        toyota.setCarEngine("16 valve");
        toyota.setCarPower(300);
        return toyota;
    }
}
