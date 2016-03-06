package com.assignment2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Calculate c= new Calculate();
        System.out.println("Add Float:"+c.floatAdd(20.0,10.0));
        System.out.println("Multiply Int:"+c.intMultiply(5,2));
        System.out.println("Bigger:"+c.bigger(100,200));
        System.out.println("Smaller:"+c.smaller(20,2));

    }
}
