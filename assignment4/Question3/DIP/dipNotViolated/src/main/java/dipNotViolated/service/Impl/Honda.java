package dipNotViolated.service.Impl;

import dipNotViolated.domain.Car;
import dipNotViolated.service.InterfaceCar;

/**
 * Created by student on 2016/03/22.
 */
public class Honda implements InterfaceCar {
    public void displayCar() {
        Car honda = new Car("S2000","siKash",300);
        System.out.println(honda.toString());
    }
    public Car getCarInfo() {
        Car honda = new Car("S2000","siKash",300);
        return honda;
    }
}
