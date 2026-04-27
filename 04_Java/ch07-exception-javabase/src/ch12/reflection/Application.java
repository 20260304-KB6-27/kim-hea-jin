package ch12.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Application {
  public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

    // Reflection
    // 프로그램이 실행되는 동안(런타임)에 클래스의 정보를 꺼내거나 실행시킬 수 있는 기능
    // Spring framework 내부에서 @Controller @Aurowired 처리 시 사용

    Class car = Car.class;

    System.out.println("생성자 정보");

    // 모든 생성자 조회후 배열에 저장
    Constructor[] constructors = car.getDeclaredConstructors();

    Car car2 = (Car) constructors[0].newInstance();

    car2.drive();  // new를 사용하지 않고도 메서드 호출 가능

    Field[] fields = car.getDeclaredFields();  // private도 가져옴
    Field[] fields2 = car.getFields();  // public만 가져옴

    for (Field field : fields) {
      System.out.println(field.getType().getName() + " field = " + field.getName());
    }
  }
}
