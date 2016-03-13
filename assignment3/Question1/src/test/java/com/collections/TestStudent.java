package com.collections;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/03/08.
 */
public class TestStudent {

    @Before
    public void setUp() throws Exception {
        Student stud = new Student();
    }

    @Test
    public void testStudentDetails() throws Exception {

    }

    @Test
    public void testDisplay() throws Exception {

        Student stud = new Student("KC05061995","Kashiefa","Cottle","BNA");
        stud.display();

    }
}
