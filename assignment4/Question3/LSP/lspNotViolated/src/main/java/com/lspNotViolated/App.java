package com.lspNotViolated;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Quadrilateral rec = new Rectangle(7,5);
        Quadrilateral square = new Square(5);

        System.out.println("Area of Rectangle:"+rec.getArea());
        System.out.println("Area of Square:"+square.getArea());

    }
}
