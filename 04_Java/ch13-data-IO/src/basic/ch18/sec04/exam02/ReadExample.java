package basic.ch18.sec04.exam02;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {
  public static void main(String[] args) {
    try {
      Reader reader = null;

      // 한 글자씩 읽기
      reader = new FileReader("resource/test.txt");
      while (true) {
        int data = reader.read();
        if (data == -1) break;
        System.out.print((char) data);
      }
      reader.close();
      System.out.println();

      // 배열로 읽기
      reader = new FileReader("resource/test.txt");
      char[] data = new char[100];
      while (true) {
        int num = reader.read(data);
        if (num == -1) break;
        for (int i=0; i<num; i++) {
          System.out.print(data[i]);
        }
      }
      reader.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
