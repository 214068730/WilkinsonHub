package composition;

import composition.domain.Student;
import composition.services.IStudent;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestStudent {

    private IStudent student;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        student =(IStudent)ctx.getBean("student");
    }

    @Test
    public void testStudentDetails() throws Exception {
        Student cputStudent = student.getStudent();
        System.out.println(cputStudent.toString());
    }

   @Test
    public void testName() throws Exception {
        Student cputStudent = student.getStudent();
        Assert.assertEquals(cputStudent.getName(),"Siraaj");
        Assert.assertEquals(cputStudent.getSurname(),"Wilkinson");
    }

}
