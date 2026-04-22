package lecture.exam03;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        FileService fileService = new FileService();

        try {
            fileService.createFile();
            fileService.readFile();
        } catch (IOException e) {
            System.out.println("파일 서비스 실패");
        }

        System.out.println("프로그램 종료");

    }
}
