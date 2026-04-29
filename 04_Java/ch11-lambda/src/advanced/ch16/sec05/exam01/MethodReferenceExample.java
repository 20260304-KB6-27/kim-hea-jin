package advanced.ch16.sec05.exam01;

public class MethodReferenceExample {
  public static void main(String[] args) {
    Person person = new Person();

    // 람다식
    // person.action((x, y) -> Computer.staticMethod(x, y));
    // static method 참조
    person.action(Computer :: staticMethod);

    Computer com = new Computer();
    // 람다식
    // person.action((x, y) -> com.instanceMethod(x, y));
    // instance method 참조
    person.action(com :: instanceMethod);
  }
}
