package com.assignment5.employee;

/**
 * Created by student on 2016/04/01.
 */
public class Employee {
    String name;
    String surname;
    String empCode;

    public Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.surname = employeeBuilder.surname;
        this.empCode = employeeBuilder.empCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmpCode() {
        return empCode;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", empCode='" + empCode + '\'' +
                '}';
    }

    public static class EmployeeBuilder{
        String name;
        String surname;
        String empCode;

        public EmployeeBuilder name(String name){
            this.name = name;
            return this;
        }

        public EmployeeBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public EmployeeBuilder employeeCode(String empCode){
            this.empCode = empCode;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.name = employee.name;
            this.surname = employee.surname;
            this.empCode = employee.empCode;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
