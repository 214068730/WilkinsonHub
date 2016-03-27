package composition;

import composition.domain.Person;
import composition.domain.Student;
import composition.services.Impl.StudentImpl;


public class App 
{
    public static void main( String[] args )
    {

        Student student = new StudentImpl().getStudent();
        System.out.println("Before");
        System.out.println(student.toString());
        System.out.println("\n"+"After name is changed");
        student.setName("Shireen");
        System.out.println(student.toString());

    }
}
