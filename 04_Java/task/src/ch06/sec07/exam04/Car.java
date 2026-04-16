package ch06.sec07.exam04;

public class Car {
    // field
    String company = "현차";
    String model;
    String color;
    int maxSpeed;

    // constructor
    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
