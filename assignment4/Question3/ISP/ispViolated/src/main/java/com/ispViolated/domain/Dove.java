package com.ispViolated.domain;

import com.ispViolated.services.Bird;

/**
 * Created by student on 2016/03/27.
 */
public class Dove implements Bird {
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

