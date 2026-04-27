package basic.ch13.sec02.exam01;

public class Application {
  public static void main(String[] args) {

    // product1 instance에서 Kind의 type: TV
    Product<TV, String> product1 = new Product<>();

    // compile 시 타입 지정되므로 Setter의 매개값은 타입에 맞춰 지정
    product1.setKind(new TV());
    product1.setModel("스마트 TV");

    TV tv = product1.getKind();
    String string = product1.getModel();

    Product<Car, String> product2 = new Product<>();
    product2.setKind(new Car());
    product2.setModel("하이브리드 차");

    Car car = product2.getKind();
    String string1 = product2.getModel();
  }
}
