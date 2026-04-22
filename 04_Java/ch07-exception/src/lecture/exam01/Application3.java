package lecture.exam01;

public class Application3 {
    public static void main(String[] args) {

        // 상황3. 사용자의 입력문자열을 숫자로 치환 프로그램

        String inputStr = "23";
        // inputStr 숫자 형식 아닐때 NumberFormatException 발생
        int num = Integer.parseInt(inputStr);
        System.out.println("num: " + num);

        System.out.println("프로그램 종료");

    }
}

/*
    자바에서의 예외
    1. 클래스의 형태로 구성
        - 예외 발생위치, 원인, 메세지 등의 정보를 포함하고 캡슐화 하기 위한 객체지향개념 탑재
    2. 상속 구조로 계층화
        - 상속을 통해 여러 예외클래스들을 체계적으로 분류하고 관리할 수 있음

    * throw : 예외를 강제로 발생시키는 문법
    특정 상황에서 "throw new 예외클래스([예외메세지]);" 구문으로 예외를 발생시키고 있음
 */

