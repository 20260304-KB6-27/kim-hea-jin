package lecture.section02.terminate;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
  public static void main(String[] args) {

    // IntStream: sum, count 연산 제공
    // max, min, sum, 평균 등
    long count = IntStream.range(1, 10).count();
    System.out.println("count = " + count);

    // OptionalInt
    // max 값이 없을 수 있으므로 OptionalInt 사용
    OptionalInt max = IntStream.range(1, 10).max();
  }
}
