package lecture.exam02;

public class Application1 {
    public static void main(String[] args) {

        int inputNum = 5;
        if (inputNum != 0) {  // 예외 사전 방지
            System.out.println("10 / 사용자입력값: " + 10 / inputNum);
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println("프로그램 종료");
    }
}
