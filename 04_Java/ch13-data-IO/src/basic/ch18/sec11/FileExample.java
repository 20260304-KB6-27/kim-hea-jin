package basic.ch18.sec11;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExample {
  public static void main(String[] args) throws Exception{

    File file = new File("resource/file1.txt");

    if (file.exists() == false) {
      System.out.println("해당 파일은 없는 파일입니다.");
    } else if (file.isDirectory()) {
      System.out.println("<dir> " + Paths.get("resource/file1.txt"));
    } else if (file.isFile()) {
      System.out.println("파일 경로: " + Paths.get("resource/file1.txt"));
      System.out.println("파일 크기: " + Files.size(Paths.get("resource/file1.txt")));
    }
  }
}
