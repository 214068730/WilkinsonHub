package com.assignment5.employee.factories;

import com.assignment5.employee.Employee;

/**
 * Created by student on 2016/04/03.
 */
public interface EmployeeFactory {
    public Employee createEmployee(String empCode,String empName,String empSurname);
}
