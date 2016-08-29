package com.collections;

/**
 * Created by student on 2016/03/10.
 */
public class Car {


    private String carRegNumber;
    private String carEngine;
    private int carPower;
    private String carName;
    private int carModel;



    public Car(){}

    public Car(String carRegNumber ,String carName,int carModel,String carEngine,int carPower){
        this.carRegNumber = carRegNumber;
        this.carName = carName;
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.carPower = carPower;
    }


    //Setters
    public void setCarNumber(String carRegNumber){
        this.carRegNumber = carRegNumber;
    }

    public void setEngine(String carEngine){
        this.carEngine = carEngine;
    }

    public void setPower(int carPower){
        this.carPower = carPower;
    }

    public void setName(String carName){
        this.carName = carName;
    }

    public void setModel(int carModel){
        this.carModel = carModel;
    }

    //Getters
    public String getCarEngine(){
        return this.carEngine;
    }

    public int getCarPower(){
        return this.carPower;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getCarModel(){
        return this.carModel;
    }

    public String  getCarNumber(){
        return this.carRegNumber;
    }


    public void display(){
        System.out.println("Registration Number:"+this.carRegNumber);
        System.out.println("Name: "+this.carName);
        System.out.println("Model: "+this.carModel);
        System.out.println("Car Engine: "+this.carEngine);
        System.out.println("Power: "+this.carPower+"kW");
    }

    public String toString()
    {

        return(carRegNumber+"\t"+carName+"\t"+carModel+"\t"+carEngine+"\t"+carPower+"\n");
    }

}
