package lecture.exam04;

import lecture.exam01.Application1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        // 상황. 특정 파일 읽어들이기 (FileInputStream이라는 "자원" 사용)

//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream("test.txt");
//            System.out.println("fileInputStream으로 파일 읽어들이는 코드 실행중 (여기서도 다른 예외가 발생할 수 있어요)");
//            System.out.println("파일 읽어들이기 완료");
//        } catch (FileNotFoundException e) {
//            System.out.println("파일을 찾지 못했습니다.");
//        } finally {
//            // 자원 반납(close) 필수
//            if (fileInputStream != null) {
//              try {
//                fileInputStream.close();
//              } catch (IOException e) {
//                throw ne      w RuntimeException(e);
//              }
//            }
//        }

        // try() 안에 작성해야하는 객체는 반드시 AutoClosable interface 구현하는 구현클래스여야 함
        try(FileInputStream fileInputStream1 = new FileInputStream("test.txt")){  // 마지막에 자동close
            System.out.println("fileInputStream으로 파일 읽어들이는 코드 실행중 (여기서도 다른 예외가 발생할 수 있어요)");
            System.out.println("파일 읽어들이기 완료");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다.");
        } catch (IOException e) {  // close() 예외처리
            throw new RuntimeException(e);
        }

        System.out.println("프로그램 종료");


        /*
            try~with~resource
            자원 사용 후 자동으로 반납까지 진행해주는 구문 (jdk 1.7 때 추가)

            try(자원 객체 생성 구문) {

            } catch(예외클래스 매개변수) {

            } // finally 구문에 close 코드 생략 가능 => 자동으로 close() 실행
         */


    }
}
