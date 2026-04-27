package ch12.annotation;

public class Service {

  // value, number default
  @PrintAnnotation
  public void method1() {
    System.out.println("실행내용 1");
  }

  // value = "*", number = default
  @PrintAnnotation("*")
  public void method2() {
    System.out.println("실행내용 2");
  }

  // value, number 지정
  @PrintAnnotation(value = "*", number = 20)
  public void method3() {
    System.out.println("실행내용 3");
  }
}
