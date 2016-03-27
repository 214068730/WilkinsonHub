package com.lspNotViolated;

/**
 * Created by student on 2016/03/22.
 */
public class Square extends Quadrilateral {

    public Square() {
    }

    public Square(int width) {
        super.setShape(width,width);

    }

    public void setSquare(int width){
        super.setShape(width,width);

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
