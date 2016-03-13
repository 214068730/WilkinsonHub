package com.question3.services.Impl;

import com.question3.domain.Car;
import com.question3.services.CarInfo;

/**
 * Created by student on 2016/03/13.
 */
public class Ford  implements CarInfo{
    public Car getCarInfo() {
        Car ford = new Car();
        ford.setName("Serria XR8");
        ford.setCarID("CA1978683");
        ford.setCarPower(500);
        ford.setCarEngine("V8");

        return  ford;
    }
}
