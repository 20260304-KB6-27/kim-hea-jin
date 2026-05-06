package lecture;

import java.io.*;

public class ex04_CharacterConvertStreamExample {
  public static void main(String[] args) throws Exception {

    String str = "문자 변환 스트림을 사용합니다.";

    write(str);  // 문자열 저장

    String data = read();  // 문자열 읽기

    System.out.println(data);
  }

  private static String read() throws Exception {

    InputStream is = new FileInputStream("resource/test.txt");

    // 바이트 스트림 -> 문자열 스트림 (문자 변환 보조 스트림)
    Reader reader = new InputStreamReader(is, "UTF-8");

    // data 읽어올 공간
    char[] data = new char[100];

    // 파일에서 문자 데이터를 읽고 문자수 반환
    int num = reader.read(data);

    String str = new String(data, 0, num);

    return str;
  }

  private static void write(String str) throws Exception {

    // 바이트 스트림
    OutputStream os = new FileOutputStream("resource/test.txt");

    // 바이트 스트림을 문자 스트림으로 변환 (UTF-8 인코딩 사용
    Writer writer = new OutputStreamWriter(os, "UTF-8");

    writer.write(str);

    writer.flush();

    writer.close();
  }

}
