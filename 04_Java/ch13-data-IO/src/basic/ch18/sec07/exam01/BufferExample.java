package basic.ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
  public static void main(String[] args) throws Exception {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("resource/originalFile1.jpg"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("resource/originalFile2.jpg"));

    long startTime = System.nanoTime();

    int data;
    while ((data = bis.read()) != -1) {
      bos.write(data);
    }
    bos.flush();

    long endTime = System.nanoTime();

    System.out.println(endTime - startTime);
  }
}
