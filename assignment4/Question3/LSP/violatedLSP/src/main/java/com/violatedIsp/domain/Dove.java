package com.violatedIsp.domain;

import com.violatedIsp.service.Bird;

/**
 * Created by student on 2016/03/24.
 */
public class Dove implements Bird{
    public void eat() {
        System.out.println("Dove is eating");
    }

    public void fly() {
        System.out.println("Dove is flying");
    }

    public void sleep() {
        System.out.println("Dove is sleeping");

    }
}
