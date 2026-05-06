package lecture;

import java.io.*;

// Buffer Stream (보조 스트림) 추가
public class ex05_BufferStreamExample {
  public static void main(String[] args) throws Exception {

    // 기본 입출력 스트림
    FileInputStream fis = new FileInputStream("resource/fuji.jpg");
    FileOutputStream fos = new FileOutputStream("resource/fuji-copy.jpg");

    // 버퍼 입출력 스트림
    FileInputStream fis2 = new FileInputStream("resource/fuji.jpg");
    FileOutputStream fos2 = new FileOutputStream("resource/fuji-copy2.jpg");

    BufferedInputStream bis = new BufferedInputStream(fis2);
    BufferedOutputStream bos = new BufferedOutputStream(fos2);

    long nonBufferTime = copy(fis, fos);  // 읽고 복사하는데 걸리는 시간
    System.out.println("버퍼 미사용: \t" + nonBufferTime);

    long bufferTime = copy(bis, bos);
    System.out.println("버퍼 사용: \t" + bufferTime);
  }

  private static long copy(InputStream fis, OutputStream fos) throws Exception {
    long start = System.nanoTime();

    int data;

    while ((data = fis.read()) != -1) {  // 파일 읽기

      fos.write(data);  // 복사
    }
    fos.flush();

    return System.nanoTime() - start;
  }
}
