package com.assignment3;

import com.assignment3.services.Impl.Bmw;
import com.assignment3.services.Impl.Ford;
import com.assignment3.services.Impl.Toyota;
import com.assignment3.domain.Car;
import com.assignment3.services.CarInfo;


public class App 
{
    public static void main( String[] args )
    {
         CarInfo car = new Ford();
         Car c1 = car.getCarInfo();
         System.out.println(c1.toString());

         CarInfo car2 = new Toyota();
         Car toyota = car2.getCarInfo();
         System.out.println(toyota.toString());

         CarInfo car3 = new Bmw();
         Car bmw = car3.getCarInfo();
         System.out.println(bmw.toString());
    }
}
