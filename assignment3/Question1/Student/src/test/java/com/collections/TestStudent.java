package com.collections;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/03/10.
 */
public class TestStudent {

    @Before
    public void setUp() throws Exception {
        Student stud = new Student();
    }

    @Test
    public void testStudentDetails() throws Exception {

        Student stud = new Student("KC05061995","Kashiefa","Cottle","BNA");
        Assert.assertEquals("Kashiefa",stud.getName());
        Assert.assertEquals("Cottle",stud.getSurname());
        Assert.assertEquals("KC05061995",stud.getStudNumber());
        Assert.assertEquals("BNA",stud.getCourse());
    }

    @Test
    public void testDisplay() throws Exception {

        Student stud = new Student("KC05061995","Kashiefa","Cottle","BNA");
        stud.display();

    }
}
