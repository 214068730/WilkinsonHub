package composition.domain;

/**
 * Created by student on 2016/03/27.
 */
public class Student {
    String studNumber;
    Person person;

    public String getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(String studNumber) {
        this.studNumber = studNumber;
    }


    public Student(String studNumber, Person person) {
        this.studNumber = studNumber;
        this.person = person;
    }

    public String getName(){
        return person.getName();
    }

    public String getSurname(){
        return person.getSurname();
    }

    public int getAge(){
        return person.getAge();
    }

    public void setName(String name){
        person.setName(name);
    }

    public void setSurname(String surname){
        person.setSurname(surname);
    }

    public void setAge(int age){
        person.setAge(age);
    }

    @Override
    public String toString() {
        return "Student\n"+ studNumber + '\t'+person.getName()+"\t"+person.getSurname()+"\t"+person.getAge();
    }
}
