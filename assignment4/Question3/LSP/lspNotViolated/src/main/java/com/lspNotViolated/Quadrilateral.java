package com.lspNotViolated;

/**
 * Created by student on 2016/03/22.
 */
public class Quadrilateral {
    int width;
    int height;

    public void setShape(int width,int height){
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        return width * height;
    }
}
