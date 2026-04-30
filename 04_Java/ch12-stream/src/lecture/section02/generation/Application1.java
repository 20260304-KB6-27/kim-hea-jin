package lecture.section02.generation;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
  public static void main(String[] args) {

    // 배열
    String[] sarr = new String[] {"java", "mysql", "jdbc"};

    // 시작인덱스 ~ 끝인덱스(포함X) 부분 배열 추출
    Stream<String> strStream = Arrays.stream(sarr, 0, 2);
    strStream.forEach(System.out::println);

    Stream<String> builderStream = Stream.<String>builder()
            .add("홍길동")
            .add("유관순")
            .add("윤봉길")
            .build();
  }
}
