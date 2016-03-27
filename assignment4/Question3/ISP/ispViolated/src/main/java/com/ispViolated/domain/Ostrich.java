package com.ispViolated.domain;

import com.ispViolated.services.Bird;

/**
 * Created by student on 2016/03/27.
 */
public class Ostrich implements Bird {
    public void eat() {
        System.out.println("Ostrich is eating");
    }

    public void fly() {
        System.out.println("Ostrich cannot fly");
    }

    public void sleep() {
        System.out.println("Ostrich is sleeping");
    }
}

