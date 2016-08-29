package dipNotViolated.domain;

import dipNotViolated.service.InterfaceCar;

/**
 * Created by student on 2016/03/22.
 */
public class Manufacture {

    InterfaceCar vehicle;

    public void createCar(InterfaceCar vehicle){
        this.vehicle = vehicle;
    }

   public void display(){
        vehicle.displayCar();
   }


}
