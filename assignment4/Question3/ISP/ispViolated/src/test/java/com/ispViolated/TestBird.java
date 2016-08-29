package com.ispViolated;

import com.ispViolated.domain.Dove;
import com.ispViolated.domain.Ostrich;
import com.ispViolated.services.IDove;
import com.ispViolated.services.IOstrich;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/27.
 */
public class TestBird {

    private IDove doveBird;
    private IOstrich ostrichBird;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        doveBird = (IDove)ctx.getBean("dove");
        ostrichBird = (IOstrich) ctx.getBean("ostrich");
    }

    @Test
    public void testEating() throws Exception {

        Dove dove = doveBird.getDove();
        Ostrich ostrich = ostrichBird.getOstrich();
        dove.eat();
        ostrich.eat();
    }

    @Test
    public void testFlying() throws Exception {
        Dove dove = doveBird.getDove();
        Ostrich ostrich = ostrichBird.getOstrich();
        dove.fly();
        ostrich.fly();
    }


    @Test
    public void testSleeping() throws Exception {
        Dove dove = doveBird.getDove();
        Ostrich ostrich = ostrichBird.getOstrich();
        dove.sleep();
        ostrich.sleep();
    }
}

