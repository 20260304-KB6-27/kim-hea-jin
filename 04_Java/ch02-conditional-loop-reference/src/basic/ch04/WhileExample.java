package basic.ch04;

import java.util.Scanner;

public class WhileExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // 키보드와 Scanner 연결

        int speed = 0;
        boolean run = true;


        // while(조건) {반복코드}
//        while (run) {
//            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
//            System.out.print("선택 : ");
//
//            String strNum = scanner.nextLine(); // 키보드에서 입력한 한 줄 읽어서 strNum에 저장
//
//            if (strNum.equals("1")) {
//                speed++;
//                System.out.println("현재속도 : " + speed);
//            } else if (strNum.equals("2")) {
//                speed--;
//                System.out.println("현재속도 : " + speed);
//            } else {
//                run = false; // while문의 조건을 false로 만들어 loop 종료
//            }
//        }


        // do-while
        // 1번 실행후 조건확인
        do {
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.print("선택 : ");

            String strNum = scanner.nextLine(); // 키보드에서 입력한 한 줄 읽어서 strNum에 저장

            if (strNum.equals("1")) {
                speed++;
                System.out.println("현재속도 : " + speed);
            } else if (strNum.equals("2")) {
                speed--;
                System.out.println("현재속도 : " + speed);
            } else {
                run = false; // while문의 조건을 false로 만들어 loop 종료
            }
        } while (run);
    }
}
