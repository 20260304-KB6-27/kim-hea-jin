package ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        // car 객체 생성
        Car car = new Car();

        // method 호출
        car.setGas(5);
        car.isLeftGas();
        System.out.println("출발합니다.");
        car.run();
        System.out.println("gas를 주입하세요.");
    }
}
