package basic.ch13.sec02.exam01;

public class Application2 {

  public static void main(String[] args) {

    // Car(TV)Agency는 Rentable의 구현 객체이므로 매개변수로 들어갈 수 있음(upcasting)
    createObject(new CarAgency());
    createObject(new TVAgency());

  }

  public static void createObject (Rentable rentable) {

    rentable.rent();
  }
}
