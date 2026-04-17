package ch06.sec09;

public class Car {
    // field
    String model;
    int speed;

    // constructor
    public Car(String model) {
        this.model = model;
    }

    // method
    // getter setter
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void run() {
        System.out.printf("%s가 달립니다. (시속: %dkm/h)", this.model, this.speed);
    }
}
