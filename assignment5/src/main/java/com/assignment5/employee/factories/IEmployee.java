package com.assignment5.employee.factories;

/**
 * Created by student on 2016/04/03.
 */
public interface IEmployee {
    public void setNextChain(IEmployee employee);
    public void employeeTitle(String postion,String code,String name,String surname);
}
