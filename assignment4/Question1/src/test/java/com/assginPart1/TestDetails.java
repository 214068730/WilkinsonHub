package com.assginPart1;

import com.assginPart1.domain.Person;
import com.assginPart1.domain.Student;
import com.assginPart1.services.Impl.PersonInfo;
import com.assginPart1.services.PersonalInfo;
import com.assginPart1.services.StudentInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/20.
 */
public class TestDetails{
    private PersonalInfo person;
    private StudentInfo student;

    @org.junit.Before
    public void setUp() throws Exception {
            System.out.println("Testing person");
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            person =(PersonalInfo)ctx.getBean("Person");
            student =(StudentInfo)ctx.getBean("Student");
    }

    @Test
    public void testPersonDetails() throws Exception {
        Person details = person.getInfo() ;
        System.out.println(details.toString());
        Assert.assertEquals(details.getName(),"Shireen");
    }

    @Test
    public void testStudentDetails() throws Exception {
            Student studDetails = student.getStudentInfo();
            studDetails.displayStudentRecord();
    }
}
