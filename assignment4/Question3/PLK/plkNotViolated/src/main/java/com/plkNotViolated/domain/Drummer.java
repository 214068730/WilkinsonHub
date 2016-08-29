package com.plkNotViolated.domain;

/**
 * Created by student on 2016/03/27.
 */
public class Drummer {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setDrummer(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Drummer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
