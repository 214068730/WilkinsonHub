package com.srpNotViolated;

import com.srpNotViolated.domain.PrintRectangle;
import com.srpNotViolated.domain.Rectangle;
import com.srpNotViolated.service.IRectangle;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/23.
 */
public class TestRectangle {
    private IRectangle rec;
    private PrintRectangle print;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        rec = (IRectangle) ctx.getBean("rectangle");
        print =(PrintRectangle) ctx.getBean("print");
    }

    @Test
    public void testDimensions() throws Exception {
        Rectangle rectangle = rec.getRectangle();
        Assert.assertEquals(rectangle.getWidth(),8);
        Assert.assertEquals(rectangle.getHeight(),5);
    }

    @Test
    public void testArea() throws Exception {
        Rectangle rectangle = rec.getRectangle();
        Assert.assertEquals(rectangle.area(),40);
    }

    @Test
    public void testDisplay() throws Exception {
        Rectangle rectangle = rec.getRectangle();
        print.printRectangle(rectangle);
    }
}
