package lecture.section02.intermediate;

import java.util.List;
import java.util.stream.IntStream;

public class Application4 {
  public static void main(String[] args) {

    List<Integer> integerList = IntStream.of(3, 7, 0, 5, 1, 1)
            .boxed()  // IntStream -> Stream<Integer>
            .sorted()  // 기본 정렬 (오름차순), Comparator 사용가능
            .toList();  // stream -> list

    System.out.println("integerList = " + integerList);
  }
}
