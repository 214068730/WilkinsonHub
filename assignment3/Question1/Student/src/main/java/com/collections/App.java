package com.collections;

import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {

        List<Student> studList = new ArrayList();
        Student[] stud = new Student[4];
        stud[0] = new Student("214068730","Siraaj","Wilkinson","I.T");
        stud[1] = new Student("KC05061995","Kashiefa","Cottle","BNA");
        stud[2] = new Student("194086709","Shireen","Wilkinson","BCom");
        stud[3] = new Student("194086709","Shireen","Wilkinson","BCom");

        for(int i=0;i<4;i++)
            studList.add(stud[i]);

        //adding duplicate object
        studList.add(stud[0]);

        System.out.println(studList.toString());
    }
}
