package lecture.exam02;

public class Application2 {

    /*
        예외처리방법1. try-catch
        발생되는 예외를 직접 처리하는 방법

        try {
            // 예외가 발생될 수 있는 구문
        } catch(예외클래스 매개변수) {
            // 해당 예외 발생시 실행(처리)할 구문
            // 매개변수에 예외객체(예외정보 가짐)가 전달됨
            //  => 예외객체 사용 가능
        } [finally {
            // 예외 발생 여부를 떠나 반드시 마지막에 실행할 구문 작성 (생략가능)
        }]
     */

    public static void main(String[] args) {

        String inputStr = "이십삼";

        try {
            int num = Integer.parseInt(inputStr);
            System.out.println("num: " + num);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 치환 불가");
            // System.out.println(e.getMessage());  // 예외 메시지 출력
            System.out.println(e.toString());  // 예외 종류, 메시지 출력
            e.printStackTrace();  // 예외가 발생된 메서드들의 호출 스택 출력
        } finally {
            System.out.println("프로그램 종료");
        }
    }
}
