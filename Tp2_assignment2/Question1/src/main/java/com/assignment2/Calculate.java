package com.assignment2;
import java.util.Random;

/**
 * Created by student on 2016/03/03.
 */
public class Calculate {

    private int num;
    Random rand;

    public double floatAdd(double a,double b)
    {

        return(a+b);
    }

    public int intMultiply( int a,int b){
        return(a*b);
    }

    public Calculate sameObject(){

        return this;
    }

    public double  floatDivide(double a,double b){
        if( b == 0) {
            System.out.println("Cannot divide by 0");
                return 1;
        }
        else
            return (a / b);
    }

    public int bigger(int a,int b){
     if(a>b)
         return a;
     else
         return b;
    }

    public int smaller(int a,int b){
        if(a<b)
            return a;
        else
            return b;
    }

    public int random(){


        num = rand.nextInt();

        return num;
    }

}
