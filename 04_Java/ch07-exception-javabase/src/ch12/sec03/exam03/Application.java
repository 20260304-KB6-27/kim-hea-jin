package ch12.sec03.exam03;

public class Application {
  public static void main(String[] args) {
    Member m = new Member("1", "khj", 0);

    System.out.println(m.age());  // getter()
    System.out.println(m.id());

    System.out.println(m);
    System.out.println(m.toString());  // m과 동일 출력
  }
}
