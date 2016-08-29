package dipViolated.badDipExample;

/**
 * Created by student on 2016/03/22.
 */
public class Manufacture {
    Car car;

    public void createCar(Car car){
        this.car  =car;
    }

    public void displayDetails(){
        System.out.println(car.toString());
    }
}
