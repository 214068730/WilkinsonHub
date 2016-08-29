package com.adpViolated;

import com.adpViolated.car.Car;
import com.adpViolated.manufacture.Manufacture;
import com.adpViolated.service.Impl.CarImpl;
import com.adpViolated.service.Impl.ManufactureImpl;

/**
 * adp violated
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Car car = new CarImpl().getCar();
        Manufacture manufacture = new ManufactureImpl().getManufacture();
        manufacture.createCar(car);
        manufacture.displayDetails();
    }
}
