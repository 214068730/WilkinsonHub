package com.assign2Part2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/03/06.
 */
public class TestMathTools {
    @Before
    public void setUp() throws Exception {
        System.out.println("Testing MathTools");

    }
    @Test
    public void testBigger() throws Exception {
        MathTools c = new MathTools();
        Assert.assertTrue(10<c.biggerInt(10,20));
        Assert.assertTrue(20.0<c.biggerFloat(10.0,30.0));
    }

    @Test
    public void testSmaller() throws Exception {
        MathTools c = new MathTools();
        Assert.assertFalse(10<c.smallerInt(5,8));
        Assert.assertFalse(115.0<c.smallerFloat(5.0,8.0));
    }
}
