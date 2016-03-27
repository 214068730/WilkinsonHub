package com.adpNotViolated;

import com.adpNotViolated.manfacture.Manufacture;
import com.adpNotViolated.service.Honda;
import com.adpNotViolated.service.Nissan;

/**
 * adp not violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Manufacture manufacture = new Manufacture();


        manufacture.createCar(new Honda());
        manufacture.display();
        manufacture.createCar(new Nissan());
        manufacture.display();
    }
}
