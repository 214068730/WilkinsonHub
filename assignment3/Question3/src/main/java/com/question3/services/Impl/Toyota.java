package com.question3.services.Impl;

import com.question3.domain.Car;
import com.question3.services.CarInfo;

/**
 * Created by student on 2016/03/13.
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
