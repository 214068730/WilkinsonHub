package com.assginPart1;

import com.assginPart1.domain.Person;
import com.assginPart1.domain.Student;
import com.assginPart1.services.Impl.PersonInfo;
import com.assginPart1.services.Impl.StudentDetails;
import com.assginPart1.services.StudentInfo;



public class App 
{
    public static void main( String[] args )
    {
        Student student = new StudentDetails().getStudentInfo();
        Person person = new PersonInfo().getInfo();

        System.out.println("Person Details");
        System.out.println(person.toString());

        System.out.println("\n"+"Student Details");
        student.displayStudentRecord();


    }
}
