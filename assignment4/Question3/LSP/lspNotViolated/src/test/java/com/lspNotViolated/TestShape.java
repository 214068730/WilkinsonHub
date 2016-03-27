package com.lspNotViolated;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/22.
 */
public class TestShape {
    Rectangle rec;
    Square square;


    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        rec = (Rectangle)ctx.getBean("Rec");

        square = (Square)ctx.getBean("square");
    }

    @Test
    public void testShapeUnits() throws Exception {

        Assert.assertEquals(rec.getHeight(),5);
        Assert.assertEquals(rec.getWidth(),7);

        Assert.assertEquals(square.getHeight(),5);
        Assert.assertEquals(square.getWidth(),5);

    }

    @Test
    public void testShapeArea() throws Exception {
        Assert.assertEquals(rec.getArea(),35);
        Assert.assertEquals(square.getArea(),25);
    }
}
