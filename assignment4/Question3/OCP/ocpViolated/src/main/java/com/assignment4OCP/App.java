package com.assignment4OCP;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Rectangle rec = new Rectangle(7,5);
        Circle circle = new Circle(5);
        CalculateArea cal = new CalculateArea();
        System.out.println("Circle Area: "+cal.getArea(circle));
        System.out.println("Rectangle Area: "+cal.getArea(rec));
    }
}
