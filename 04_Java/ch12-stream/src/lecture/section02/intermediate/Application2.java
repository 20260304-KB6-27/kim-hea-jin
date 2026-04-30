package lecture.section02.intermediate;

import java.util.stream.IntStream;

public class Application2 {
  public static void main(String[] args) {

    IntStream intStream = IntStream.range(0, 10);

    // map: stream 내 데이터를 특정 람다식을 통해 가공, 새로운 stream으로 반환
    // peek: 중간 단계에서 데이터 확인용

    intStream.filter(i -> (i % 2) == 0)
            .peek(i -> System.out.println("중간 확인: " + i))  // 2의 배수 출력
            .map(i -> i * 5)
            .forEach(i -> System.out.println(i));  // *5 된 값 출력
  }
}
