package composition.services.Impl;

import composition.domain.Person;
import composition.domain.Student;
import composition.services.IStudent;


public class StudentImpl implements IStudent{


    public Student getStudent() {
        Person person = new Person("Siraaj","Wilkinson",21);
        Student student = new Student("214068730",person);
        return student;
    }
}
