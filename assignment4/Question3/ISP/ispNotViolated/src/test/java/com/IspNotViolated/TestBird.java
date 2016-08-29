package com.IspNotViolated;

import com.IspNotViolated.domain.Dove;
import com.IspNotViolated.domain.Ostrich;
import com.IspNotViolated.service.IDove;
import com.IspNotViolated.service.IOstrich;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/24.
 */
public class TestBird {
    private IDove doveBird;
    private IOstrich ostrichBird;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        doveBird =(IDove) ctx.getBean("dove");
        ostrichBird=(IOstrich) ctx.getBean("ostrich");
    }

    @Test
    public void testDove() throws Exception {
            Dove dove = doveBird.getDove();
            dove.eat();
            dove.fly();
            dove.sleep();
    }

    @Test
    public void testOstrich() throws Exception {
        Ostrich ostrich =  ostrichBird.getOstrich();
        ostrich.eat();
        ostrich.sleep();

    }
}
