package com.assign2Part2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/03/06.
 */
public class TestMenu {
    @Before
    public void setUp() throws Exception {
        System.out.println("in testMenu");
    }

    @Test
    public void testMainMenu() throws Exception {
        Menu main = new Menu();
        main.Display();

    }

    @Test
    public void testCalculateMenu() throws Exception {
        Menu main = new Menu();
        main.DisplayCalulate();
    }

    @Test
    public void testMathTools() throws Exception {
        Menu main = new Menu();
        main.DisplayMathTools();
    }
}
