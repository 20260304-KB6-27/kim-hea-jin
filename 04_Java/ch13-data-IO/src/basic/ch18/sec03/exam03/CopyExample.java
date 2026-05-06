package basic.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyExample {
  public static void main(String[] args) throws Exception{
    String originalFileName = "resource/test.jpg";
    String targetFileName = "resource/test2.jpg";

    FileInputStream fis = new FileInputStream(originalFileName);
    FileOutputStream fos = new FileOutputStream(targetFileName);

    int data;
    while ((data = fis.read()) != -1) {
      fos.write(data);
    }
    fos.flush();
    fos.close();
  }
}
