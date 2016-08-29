package com.assignment4OCP;

/**
 * Created by student on 2016/03/23.
 */
public class Circle {

   private double radius;

public Circle(){}
    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {

        this.radius = radius;
    }

    /*@Override
    public double getArea(Object o) {
        return radius*radius*Math.PI;
    }*/
}
