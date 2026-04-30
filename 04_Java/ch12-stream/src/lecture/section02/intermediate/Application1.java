package lecture.section02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
  public static void main(String[] args) {

    // Filter
    // 함수형 인터페이스 API
    // Predicate< ? super T> predicate

    IntStream intStream = IntStream.range(0, 10);

    // filter(조건): 조건이 참인 값들만 모아서 스트림 반환
    intStream.filter(i -> (i % 2) == 0)
            .forEach(i -> System.out.print(i + " "));
  }
}
