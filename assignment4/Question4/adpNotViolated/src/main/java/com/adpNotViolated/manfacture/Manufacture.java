package com.adpNotViolated.manfacture;

import com.adpNotViolated.vehicle.IVehicle;

/**
 * Created by student on 2016/03/27.
 */
public class Manufacture {
    IVehicle vehicle;


    public void createCar(IVehicle vehicle){
        this.vehicle = vehicle;
    }

    public void display(){
        vehicle.displayCar();
    }
}
