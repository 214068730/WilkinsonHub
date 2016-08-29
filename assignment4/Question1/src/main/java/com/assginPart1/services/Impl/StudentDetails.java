package com.assginPart1.services.Impl;

import com.assginPart1.domain.Student;
import com.assginPart1.services.StudentInfo;

/**
 * Created by student on 2016/03/20.
 */
public class StudentDetails implements StudentInfo {

    public Student getStudentInfo() {

        Student student = new Student("214068730","I.T","Siraaj","Wilkinson","Male",21);
        return student;
    }
}
