package com.question3.services.Impl;

import com.question3.domain.Car;
import com.question3.services.CarInfo;

/**
 * Created by student on 2016/03/13.
 */
public class Bmw  implements CarInfo{

    public Car getCarInfo() {
        Car bmw = new Car();
        bmw.setName("M3");
        bmw.setCarID("siKash");
        bmw.setCarPower(320);
        bmw.setCarEngine("V8");


        return bmw;
    }
}
