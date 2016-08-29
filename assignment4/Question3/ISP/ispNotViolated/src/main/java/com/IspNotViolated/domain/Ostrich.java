package com.IspNotViolated.domain;

import com.IspNotViolated.service.Bird;

/**
 * Created by student on 2016/03/24.
 */
public class Ostrich implements Bird {
    public void eat() {
        System.out.println("Ostrich is eating");
    }

    public void sleep() {
        System.out.println("Ostrich is sleeping");
    }
}
