package com.assignment4OCP;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by student on 2016/03/23.
 */
public class CalculateArea {

    private double area;
    private Rectangle rec;
    private Circle circle;


    public double getArea(Object object){

        if(object instanceof Rectangle) {
           area= getRecArea((Rectangle)object);
        }
        else
            {
                area = getCircleArea((Circle)object);
            }

        return Math.round(area * 100.0) / 100.0;
    }

    public double getRecArea(Rectangle rec) {
        return rec.getWidth() *rec.getHeight();
    }

    public double getCircleArea(Circle circle){
        return circle.getRadius()*circle.getRadius()*Math.PI;
    }
}
