package com.srpViolated;

import com.srpViolated.domain.Rectangle;
import com.srpViolated.service.IRectangle;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/23.
 */
public class TestRectangle {

    private IRectangle shapeRectangle;


    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        shapeRectangle = (IRectangle) ctx.getBean("rectangle");
    }

    @Test
    public void testDimensions() throws Exception {
        Rectangle rectangle = shapeRectangle.getRectangle();
        Assert.assertEquals(rectangle.getHeight(),5);
        Assert.assertEquals(rectangle.getWidth(),7);
    }

    @Test
    public void testArea() throws Exception {
        Rectangle rectangle = shapeRectangle.getRectangle();
        Assert.assertEquals(rectangle.area(),35);

    }
}
