package basic.ch01.sec12;

public class Type {
    public static void main(String[] args) {
        // 자료형
        // 다양한 값의 형태별로 어느정도의 크기를 하나의 값으로 취급할지
        // 컴파일러와 약속된 키워드

        // 기본 자료형
        // 정수
        byte bnum = 1;  // 1byte
        short snum = 2; // 2byte
        int inum = 1;   // 4byte 정수형 기본
        long lnum = 1L;  // 8byte

        // 실수
        float fnum = 4.0f;  // 4byte
        double dnum = 8.0; // 8byte 실수형 기본

        // 문자
        char ch;    // 2byte

        // 논리값
        boolean isTrue = true; // 1byte (true / false)

        // print
        // ctrl + D  한 줄 복사
        System.out.print("안녕");
        System.out.print("안녕");
        System.out.print("안녕");

        // sout 스니펫
        System.out.println();

        System.out.println("안녕");
        System.out.println("인녕");
        System.out.println("인녕");

        // soutv 스니펫
        System.out.println("isTrue = " + isTrue);
    }
}
