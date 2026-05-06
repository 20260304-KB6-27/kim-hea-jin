package advanced.ch18.sec10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
  public static void main(String[] args) throws Exception{

    Member m1 = new Member("fall", "단풍이");
    Product p1 = new Product("노트북", 1500000);
    int[] arr1 = {1, 2, 3};

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/object2.dat"));

    oos.writeObject(m1);
    oos.writeObject(p1);
    oos.writeObject(arr1);
    oos.close();
  }
}
