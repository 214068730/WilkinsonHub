package com.assignment2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by student on 2016/03/03.
 */

 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethod {

    @Before
    public void setUp() throws Exception {
        System.out.println("in Before");

    }

    @Test
    public void testFloat() throws Exception {
        Calculate f = new Calculate();
        Assert.assertEquals(20.0,f.floatAdd(10.0,10.0));

    }

    @Test
    public void testInt() throws Exception {
        Calculate cal = new Calculate();
        Calculate cal2 = new Calculate();
        int a = cal.intMultiply(5,5);


        Assert.assertFalse(a>cal2.intMultiply(10,10));
    }

    @Test
    public void testObjectEquality() throws Exception {
        Calculate c = new Calculate();
        Calculate c2 = new Calculate();

        Assert.assertEquals(c.floatDivide(20,2),c2.floatDivide(20,2));


    }

    @Test
    public void testObjectIdentity() throws Exception {
        Calculate c2 = new Calculate();
        Calculate c3;
        c3=c2;
        Assert.assertSame(c3.sameObject(),c2.sameObject());
    }

    @Test
    public void testTruth() throws Exception {
        Calculate c = new Calculate();
        Assert.assertTrue(10<c.floatDivide(20,1));
    }

    @Test
    public void testFail() throws Exception {
        Calculate c = new Calculate();
        Assert.assertFalse(10<c.bigger(5,2));
    }

    @Test
    public void testNull() throws Exception {
        Calculate c = null;
        Assert.assertNull(c);
    }

    @Test
    public void testNotNull() throws Exception {
        Calculate c = new Calculate();
        Assert.assertNotNull(c);
    }

    @Test
    public void testNotSame() throws Exception {
        Calculate c = new Calculate();
        Calculate c2 = new Calculate();

        Assert.assertNotSame(c.sameObject(),c2.sameObject());
    }

    @Test(timeout = 100)
    public void testTimeOut() throws Exception {
        Calculate c = new Calculate();
        int total;
        int smaller;
        int bigger;

        smaller = c.smaller(50,100);
        bigger = c.bigger(202,150);
        total = smaller+bigger;
        System.out.println(total);
    }

    @Ignore()
    public void testRandom() throws Exception {
        Calculate c = new Calculate();
        int x = c.random();
        System.out.println(x);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test() throws Exception {
        int x;
        Calculate[] c = new Calculate[3];
        x =c[4].bigger(20,3);
    }

    @Test
    public void testArrayContent() throws Exception {
        int[] num = new int[2];
        num[0] = 10;
        num[1] =10;

        Assert.assertEquals(num[0],num[1]);
    }
}
