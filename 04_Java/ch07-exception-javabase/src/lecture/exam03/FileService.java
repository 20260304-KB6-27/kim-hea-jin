package lecture.exam03;

/*
    Checked Exception (일반 예외)
    1. 컴파일 에러 발생
    2. 예외처리 코드가 필수 (컴파일러가 예외처리여부를 확인함)
        => 예외처리 코드가 없으면 프로그램 동작 자체가 불가
    3. RuntimeException 계층 제외한 Exception 계열
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileService {

    public void createFile() throws IOException{  // 예외처리 호출문(Application)에 떠넘김
//        try {
//            new File("F:\\test.txt").createNewFile();  // IOException (일반 예외)
//        } catch (IOException e) {
//            System.out.println("파일 생성 실패");
//        }

        new File("F:\\test.txt").createNewFile();
    }

    public void readFile() throws FileNotFoundException {
//        try {
//            new FileInputStream("F:\\test.txt");
//        } catch (FileNotFoundException e) {
//            System.out.println("파일 읽기 실패");
//        }

        new FileInputStream("F:\\test.txt");
    }




    /*
        예외처리방법2. throws
        발생되는 예외를 즉시 처리하지 않고 메소드 호출부로 위임(떠넘기기)하는 방법

        - 직접 처리하기 부적합하거나
        - 한 곳에서 일괄처리 하고 싶거나
        - 메소드 선언부에 발생 가능한 예외를 명시하고 싶을때

        메소드 선언부 throws 예외클래스 {
            // 예외가 발생될 수 있는 구문
        }
     */

}




