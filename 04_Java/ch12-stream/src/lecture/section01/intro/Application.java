package lecture.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

  // 1. 데이터 소스: stream이 데이터 가져오는 시작점
  // 2. 중간연산: 데이터 가공, 새로운 stream 반환, 지연 실행 (최종 연산 전까지 실행X)
  // 3. 최종연산: stream 처리 종료, 결과 생성 (stream 전체 실행), stream 재사용 불가
  public static void main(String[] args) {

    List<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "stream"));

    // stream 생성
    stringList.stream()
            // 길이가 6미만인 string으로만 이루어진 stream 반환
            .filter(s -> s.length() < 6)  // 중간연산
            // .forEach(System.out::println);
            .forEach(s -> System.out.println(s));  // 최종연산
  }
}
