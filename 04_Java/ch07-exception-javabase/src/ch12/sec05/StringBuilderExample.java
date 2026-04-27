package ch12.sec05;

public class StringBuilderExample {
  public static void main(String[] args) {

    // 문자열을 반복적으로 조합할 때 StringBuffer를 사용해서 메모리 낭비 줄임
    // buffer에 저장
    String data = new StringBuilder()
            .append("DEF")  // DEF
            .insert(0, "ABC")  // ABCDEF
            .delete(3,4)  // ABC'D'EF (index=3 삭제)
            .toString();
    System.out.println(data);
  }
}
