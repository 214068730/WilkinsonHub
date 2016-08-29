package com.nonViolatedOcp;

/**
 * Created by student on 2016/03/23.
 */
public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double Area() {
        return Math.round((radius*radius*Math.PI)*100)/100;
    }
}
