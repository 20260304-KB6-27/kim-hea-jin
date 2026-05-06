package advanced.ch18.sec10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
  public static void main(String[] args) throws Exception {

    // .dat: 데이터라는 의미만 가진 확장자
    FileOutputStream fos = new FileOutputStream("resource/object.dat");

    ObjectOutputStream oos = new ObjectOutputStream(fos);

    Member m1 = new Member("자바", 12, "java123");

    int[] arr1 = {1, 2, 3};

    oos.writeObject(m1);  // 객체를 파일 형태로 저장 (직렬화)
    oos.writeObject(arr1);

    oos.close();

    // NotSerializableException -> 직렬화 가능여부 표시해야 함 -> Member implements Serializable
  }
}
