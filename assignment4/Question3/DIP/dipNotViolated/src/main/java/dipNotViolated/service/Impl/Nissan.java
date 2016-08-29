package dipNotViolated.service.Impl;

import dipNotViolated.domain.Car;
import dipNotViolated.service.InterfaceCar;

/**
 * Created by student on 2016/03/22.
 */
public class Nissan implements InterfaceCar {


    public void displayCar() {
        Car nissan = new Car("Sti","CA4564878",150);
        System.out.println(nissan.toString());

    }

    public Car getCarInfo() {
        Car nissan = new Car("Sti","CA4564878",150);
        return nissan;
    }
}
