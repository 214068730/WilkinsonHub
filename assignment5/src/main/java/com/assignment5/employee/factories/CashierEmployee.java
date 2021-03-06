package com.assignment5.employee.factories;

import com.assignment5.employee.Employee;

/**
 * Created by student on 2016/04/03.
 */
public class CashierEmployee implements IEmployee{

    private IEmployee employee;
    Employee emp;


    public void setNextChain(IEmployee employee) {
        this.employee = employee;
    }

    public void employeeTitle(String postion,String code,String name,String surname) {
        if(postion == "packer") {
            emp = new Employee.EmployeeBuilder().employeeCode(code).name(name).surname(surname).build();
            System.out.println("Employee details:\n" + emp.toString());
            System.out.println("Job title: " + postion);
        }
        else
            System.out.println("Job title does not exist");

    }

}
