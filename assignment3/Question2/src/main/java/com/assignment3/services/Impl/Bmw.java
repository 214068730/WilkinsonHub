package com.assignment3.services.Impl;

import com.assignment3.services.CarInfo;
import com.assignment3.domain.Car;

/**
 * Created by student on 2016/03/12.
 */
public class Bmw  implements CarInfo
{

    public Car getCarInfo() {
        Car bmw = new Car();
        bmw.setName("M3");
        bmw.setCarID("siKash");
        bmw.setCarPower(320);
        bmw.setCarEngine("V8");


        return bmw;
    }
}
