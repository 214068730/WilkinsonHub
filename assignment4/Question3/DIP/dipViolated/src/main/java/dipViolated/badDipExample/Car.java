package dipViolated.badDipExample;

/**
 * Created by student on 2016/03/22.
 */
public class Car {
    String name;
    String registerNumber;
    int power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Car(String name, String registerNumber, int power) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", power=" + power +"kW"+
                '}';
    }
}
