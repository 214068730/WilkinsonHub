package com.srpNotViolated;

import com.srpNotViolated.domain.PrintRectangle;
import com.srpNotViolated.domain.Rectangle;
import com.srpNotViolated.service.Impl.RectangleImpl;

/**
 * SRP not being violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Rectangle rectangle = new RectangleImpl().getRectangle();
        PrintRectangle print = new PrintRectangle();
        print.printRectangle(rectangle);
    }
}
