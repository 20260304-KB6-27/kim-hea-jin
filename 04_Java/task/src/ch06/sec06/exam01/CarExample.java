package ch06.sec06.exam01;

public class CarExample {
    public static void main(String[] args) {
//        Car car = new Car();
//        System.out.println(car.model);  // null
//        System.out.println(car.speed);  // 0
//        System.out.println(car.start);  // false

        Car myCar = new Car("그랜저", "검정", 250);
        System.out.println(myCar.model);
        System.out.println(myCar.color);
        System.out.println(myCar.speed);
    }
}
