package com.assginPart1.services.Impl;

import com.assginPart1.domain.Person;
import com.assginPart1.services.PersonalInfo;

/**
 * Created by student on 2016/03/20.
 */
public class PersonInfo implements PersonalInfo {



    public Person getInfo() {

        Person person = new Person();
        person.setName("Siraaj");
        person.setSurname("Wilkinson");
        person.setGender("Male");
        person.setAge(21);

        return person;
    }
}
