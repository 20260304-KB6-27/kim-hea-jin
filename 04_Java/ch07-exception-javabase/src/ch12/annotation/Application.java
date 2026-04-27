package ch12.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

    // 1. Service에서 선언된 method 모두 가져옴 (method1, 2, 3)
    Method[] declaredMethod = Service.class.getDeclaredMethods();

    Method method = declaredMethod[0];  // annotation 붙은 상태

    // 2. method에 붙은 annotation 읽음
    PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

    // 3. annotation 속성값으로 구분선 출력
    if (printAnnotation != null) {

      // annotation에 정의한 속성 가져옴
      int number = printAnnotation.number();
      String value = printAnnotation.value();

      for (int i = 0; i < number; i++) {
        System.out.print(value);
      }

      System.out.println();
    }

    // 4. method 실행
    method.invoke(new Service());
  }
}
