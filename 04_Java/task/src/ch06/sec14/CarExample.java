package ch06.sec14;

public class CarExample {
    public static void main(String[] args) {
        // 객체 생성
        Car myCar = new Car();

        // 잘못된 속도로 변경
        myCar.setSpeed(-50);
        int nowSpeed = myCar.getSpeed();
        System.out.println("현재속도: " + nowSpeed);

        // 속도 60으로 변경
        myCar.setSpeed(60);
        nowSpeed = myCar.getSpeed();
        System.out.println("현재속도: " + nowSpeed);

        // 멈춤
        myCar.setStop(true);
        nowSpeed = myCar.getSpeed();
        System.out.println("현재속도: " + nowSpeed);
    }
}
