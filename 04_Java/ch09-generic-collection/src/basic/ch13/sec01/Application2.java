package basic.ch13.sec01;

public class Application2 {

  // <T extends 특정타입> -> 특정타입으로 제한
  // String type으로 제한
  public static <T extends String> Box<T> boxing(T content) {
    Box<T> box = new Box<>();
    box.setContent(content);
    return box;
  }

  // Integer type으로 제한
  public static <T extends Integer> Box<T> boxing(T content) {
    Box<T> box = new Box<>();
    box.setContent(content);
    return box;
  }

  public static void main(String[] args) {

    // Integer type의 Box instance box1 생성
    Box<Integer> box1 = boxing(100);
    int intValue = box1.getContent();
    System.out.println("intValue = " + intValue);

    // String type의 Box instance box2 생성
    Box<String> box2 = boxing("rabbit");
    String strValue = box2.getContent();
    System.out.println("strValue = " + strValue);
  }
}
