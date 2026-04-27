package basic.ch13.sec02.exam01;

public class CarAgency implements Rentable<Car>{

  @Override
  public Car rent() {

    System.out.println("자동차 객체 생성");

    // Car class instance return
    return new Car();
  }
}
