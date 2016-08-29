package com.assign2Part2;

/**
 * Created by student on 2016/03/06.
 */
public class SignIn {
    private String username;
    private String password;

    public SignIn(){}

    public SignIn(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getPassword() {
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public void Display(){
        System.out.println("Welcome: "+username);
    }

}
