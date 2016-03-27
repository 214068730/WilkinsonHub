package com.assignment4OCP;

/**
 * Created by student on 2016/03/23.
 */
public class Rectangle  {
    private double width;
    private double height;

    public Rectangle(){

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    /*@Override
    public double getArea(Object o) {
        return width*height;
    }*/
}
