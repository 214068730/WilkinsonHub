package com.IspNotViolated.domain;

import com.IspNotViolated.service.Bird;
import com.IspNotViolated.service.Fleeable;

/**
 * Created by student on 2016/03/24.
 */
public class Dove implements Bird,Fleeable {
    public void eat() {
        System.out.println("Dove is eating");
    }

    public void sleep() {
        System.out.println("Dove is sleeping");
    }

    public void fly() {
        System.out.println("Dove is flying");
    }
}
