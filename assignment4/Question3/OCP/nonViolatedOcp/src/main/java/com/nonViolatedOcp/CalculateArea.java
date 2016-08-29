package com.nonViolatedOcp;

/**
 * Created by student on 2016/03/23.
 */
public class CalculateArea {
    private  double area;

    public double getArea(Shape shape){

        area = shape.Area();
        return Math.round(area * 100.0) / 100.0;
    }
}
