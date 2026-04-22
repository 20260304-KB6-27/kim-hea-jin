package lecture.exam01;

/*
    프로그램 동작 중 예상치 못한 사태 발생시
    실행중인 프로그램이 비정상적으로 종료되거나 영향을 받는 상황
    => 오류 / 예외


    오류(Error)
    - 프로그램의 심각한 문제 (주로, 시스템상 또는 하드웨어 등)
       => 프로그램이 비정상적으로 종료
    - 개발자가 미리 예측 불가


    예외(Exception)
    - 오류와 마찬가지로 프로그램이 비정상적으로 종료
    - 단, 발생할 수 있는 상황을 미리 예측하고 처리할 수 있는 "미약한 오류"

 */




public class Application1 {
    public static void main(String[] args) {

        // 상황1. 사용자 입력값으로 나눗셈 연산 프로그램

        int inputNum = 5;
        // inputNum = 0 -> ArithmeticException 발생
        System.out.println("10 / 사용자입력값: " + 10 / inputNum);
        System.out.println("프로그램 종료");
    }
}
