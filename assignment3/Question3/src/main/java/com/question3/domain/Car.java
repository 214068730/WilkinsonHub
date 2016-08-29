package com.question3.domain;

/**
 * Created by student on 2016/03/12.
 */
public class Car {

    String name;
    String carID;
    String carEngine;
    int carPower;

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public void setCarPower(int carPower) {
        this.carPower = carPower;
    }

    public String getName() {
        return name;
    }

    public String getCarID() {
        return carID;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public int getCarPower() {
        return carPower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carID='" + carID + '\'' +
                ", carEngine='" + carEngine + '\'' +
                ", carPower=" + carPower +"kw"+
                '}';
    }
}
