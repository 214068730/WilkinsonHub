package com.violatedIsp.domain;

import com.violatedIsp.service.Bird;

/**
 * Created by student on 2016/03/24.
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
