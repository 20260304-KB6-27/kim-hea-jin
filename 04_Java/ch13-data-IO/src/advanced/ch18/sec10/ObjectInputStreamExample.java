package advanced.ch18.sec10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {
  public static void main(String[] args) throws Exception {

    FileInputStream fis = new FileInputStream("resource/object.dat");

    ObjectInputStream ois = new ObjectInputStream(fis);

    // 역직렬화
    Member m1 = (Member) ois.readObject();
    int[] arr1 = (int[]) ois.readObject();

    ois.close();
    System.out.println(m1);
    System.out.println(Arrays.toString(arr1));

  }
}
