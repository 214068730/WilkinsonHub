package dipViolated;

import dipViolated.badDipExample.Car;
import dipViolated.badDipExample.Manufacture;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Car car = new Car("Toyota","CA546487",120);
        Manufacture manufacture = new Manufacture();
        manufacture.createCar(car);
        manufacture.displayDetails();
    }
}
