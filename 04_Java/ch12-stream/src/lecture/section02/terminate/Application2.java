package lecture.section02.terminate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application2 {
  public static void main(String[] args) {

    // collect(): Collectors 클래스에 정적 메소드 사용가능, 컬렉션을 출력으로 받을 수 있음
    List<Member> memberList = Arrays.asList(
            new Member("test01", "testName01"),
            new Member("test02", "testName02"),
            new Member("test03", "testName03"),
            new Member("user04", "userName04"),
            new Member("user05", "userName05")
    );

    List<String> collect = memberList.stream()
            .map(m -> m.getMemberName())
//            .collect(Collectors.toList());
            .toList();

    // 사용도 낮음 (알아만 두기)
    String styr = memberList.stream()
            .map(Member::getMemberName)  // Type: String Stream
            // joining(구분자, prefix, suffix)
            .collect(Collectors.joining(" || ", "(", ")"));
    System.out.println("styr = " + styr);

    // groupingBy
    Map<String, List<Member>> groupMap =
            memberList.stream()
                    .collect(Collectors.groupingBy(member -> {
                      // grouping 기준 정의
                      if (member.getMemberId().startsWith("user")) {
                        return "USER";
                      } else {
                        return "TEST";
                      }
                    }));
    System.out.println("groupMap = " + groupMap);
  }
}
