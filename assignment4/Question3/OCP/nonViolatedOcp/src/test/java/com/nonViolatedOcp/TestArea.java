package com.nonViolatedOcp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/23.
 */
public class TestArea {
    Shape rectangle;
    Shape circle;
    CalculateArea calArea;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        rectangle =(Rectangle)ctx.getBean("rectangle");
        circle=(Circle)ctx.getBean("circle");
        calArea=(CalculateArea) ctx.getBean("calArea");
    }

    @Test
    public void testArea() throws Exception {
        Assert.assertEquals(rectangle.Area(),35.0);
        Assert.assertEquals(circle.Area(),12.0);
    }
}
