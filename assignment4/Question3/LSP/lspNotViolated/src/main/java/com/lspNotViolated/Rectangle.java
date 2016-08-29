package com.lspNotViolated;

/**
 * Created by student on 2016/03/22.
 */
public class Rectangle extends Quadrilateral {

    public void setRectangle(int width,int height){
        super.setShape(width,height);
    }

    public Rectangle(int width,int height) {
        super.setShape(width,height);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
