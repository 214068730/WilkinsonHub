package com.nonViolatedOcp;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Shape rec = new Rectangle(7,5);
        Shape circle = new Circle(5);
        CalculateArea calArea = new CalculateArea();
        System.out.println("Circle Area: "+calArea.getArea(circle));
        System.out.println("Rectangle Area: "+calArea.getArea(rec));
    }
}
