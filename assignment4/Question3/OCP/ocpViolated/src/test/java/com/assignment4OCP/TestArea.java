package com.assignment4OCP;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/23.
 */
public class TestArea {

    private Rectangle rec;
    private Circle circle;
    private CalculateArea calArea;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        rec = (Rectangle) ctx.getBean("rectangle");
        circle = (Circle)ctx.getBean("circle");
        calArea=(CalculateArea) ctx.getBean("calArea");
    }

    @Test
    public void testRectangle() throws Exception {
        Assert.assertEquals(rec.getWidth(),8.0);
        Assert.assertEquals(rec.getHeight(),5.0);
    }

    @Test
    public void testCircle() throws Exception {
            Assert.assertEquals(circle.getRadius(),5.0);
    }

    @Test
    public void testArea() throws Exception {
        Assert.assertEquals(calArea.getArea(rec),40.0);
        Assert.assertEquals(calArea.getArea(circle),78.54);
    }

}
