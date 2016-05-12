package runningshop.assignment7.domain.employee;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import runningshop.assignment7.domain.address.AddressVO;

/**
 * Created by Siraaj on 04/14/2016.
 */
public class Employee implements Serializable, IEmployeeEvents {
    String name;
    String surname;
    Long empCode;
    AddressVO address;
    DateFormat dateFormat;
    Date date;
    Map<Long,Date> employeeEventsHistory = new HashMap();


    public Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.surname = employeeBuilder.surname;
        this.empCode = employeeBuilder.empCode;
        this.address = employeeBuilder.address;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        employeeHired();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPostalCode(){
        return address.getPostalCode();
    }

    public String getStreetName(){
        return address.getStreetName();
    }

    public String getSuburb(){
        return address.getSuburb();
    }

    public Long getEmpCode() {
        return empCode;
    }

    public AddressVO getAddress(){
        return address;
    }

    public void viewEmployee() {
       System.out.println(empCode);
        System.out.println(name+" "+surname);
        System.out.println("\n"+"Address:");
        address.viewAddress();

    }

    @Override
    public void employeeHired() {
        employeeEventsHistory.put(empCode, date);
    }

    public void employeesHistory(Long code){
            if(!employeeEventsHistory.get(code).equals(null)) {
                System.out.println("Employee hired on");
                System.out.println(employeeEventsHistory.get(code));
                System.out.println("Employee ID: "+empCode);
                System.out.println("Employee Name: "+name);
            }
    }

    public static class EmployeeBuilder{

        Long empCode;
        String name;
        String surname;
        AddressVO address;

        public EmployeeBuilder name(String name){
            this.name = name;
            return this;
        }

        public EmployeeBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public EmployeeBuilder employeeCode(Long empCode){
            this.empCode = empCode;
            return this;
        }

        public EmployeeBuilder address(AddressVO address){
            this.address = address;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.name = employee.name;
            this.surname = employee.surname;
            this.empCode = employee.empCode;
            this.address = employee.address;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
