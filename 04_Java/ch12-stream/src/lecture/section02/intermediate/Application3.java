package lecture.section02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Application3 {
  public static void main(String[] args) {

    // flatMap: 중첩된 구조를 한 단계 제거 후 단일 컬렉션으로 만듦

    List<List<String>> list = Arrays.asList(
            Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
            Arrays.asList("java", "spring", "springboot")
    );
    System.out.println(list);  // 2차원 배열

    List<String> strList = list.stream()
            .flatMap(Collection::stream)  // collection -> stream
            .toList();  // stream -> list
    System.out.println(strList);  // 1차원 배열
  }
}
