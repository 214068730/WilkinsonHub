package com.question3;

import com.question3.domain.Car;
import com.question3.services.CarInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        CarInfo car;
        CarInfo car2;
        CarInfo car3;

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        car =(CarInfo)ctx.getBean("Toyota");
        Car vehicle = car.getCarInfo();
        car2=(CarInfo) ctx.getBean("Bmw");
        Car vehicle2 = car2.getCarInfo();
        car3 =(CarInfo) ctx.getBean("Ford");
        Car vehicle3 = car3.getCarInfo();

        System.out.println("Top 3 cars:");
        System.out.println(vehicle2.toString());
        System.out.println(vehicle3.toString());
        System.out.println(vehicle.toString());

    }
}
