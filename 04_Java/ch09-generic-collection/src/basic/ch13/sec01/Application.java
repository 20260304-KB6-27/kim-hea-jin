package basic.ch13.sec01;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void boxing() {

  }

  // 데이터 형색에 의존하지 않고 하나의 값이 여러 데이터 타입을 가질 수 있어
  // 재사용성이 높은 프로그래밍 개발 가능
  public static void main(String[] args) {
    Box<String> box1 = new Box<>();  // content type: String
    box1.content = "박스의 콘텐츠입니다.";
    System.out.println("box1 = " + box1.content);
    
    Box<Integer> box2 = new Box<>();  // content type: Integer 
    box2.content = 100;
    System.out.println("box2 = " + box2.content);

    // generic, 다형성 적용된 예제코드
    // List<String> list = new ArrayList<>();
  }
}
