package com.assignment5.employee.factories;

import com.assignment5.employee.Employee;

/**
 * Created by student on 2016/04/03.
 */
public class EmployeeFactoryImpl implements EmployeeFactory {
    private static EmployeeFactoryImpl factory = null;

    private EmployeeFactoryImpl(){

    }


    public static EmployeeFactoryImpl getInstance(){
        if(factory == null)
            factory = new EmployeeFactoryImpl();
        return factory;
    }

    public Employee createEmployee(String empCode,String empName,String empSurname) {
        Employee employee = new Employee.EmployeeBuilder().employeeCode(empCode).name(empName).surname(empSurname).build();
        return employee;
    }
}
