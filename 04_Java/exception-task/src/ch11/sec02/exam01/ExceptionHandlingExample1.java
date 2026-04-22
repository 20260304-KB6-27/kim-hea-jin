package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
  public static void printLength(String data) {
    int result = data.length();
    System.out.println("문자 수: " + result);
  }

  public static void main(String[] args) {
    System.out.println("[프로그램 시작]\n");

    try {
      printLength("ThisIsJava");
      printLength(null); // NullPointerException 발생 (null의 문자길이 구할 수 없음)
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());  // 예외 객체 메시지 출력
      e.printStackTrace();  // 스택 추적 내용 출력
    } finally {
      System.out.println("[프로그램 종료]");
    }
  }
}
