package com.srpViolated;

import com.srpViolated.domain.Rectangle;
import com.srpViolated.service.Impl.RectangleImpl;

/**
 * SRP has been violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Rectangle rectangle = new RectangleImpl().getRectangle();
        rectangle.printRectangle();
    }
}
