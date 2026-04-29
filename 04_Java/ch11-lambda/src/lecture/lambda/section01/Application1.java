package lecture.lambda.section01;

public class Application1 {
  public static void main(String[] args) {

    // 1. 구현 Class 객체 생성
    Calculator c1 = new CalculatorImpl();
    System.out.println("1. " + c1.sum(1, 5));

    // 2. 익명구현객체
    Calculator c2 = new Calculator() {
      @Override
      public int sum(int a, int b) {
        return a + b;
      }
    };
    System.out.println("2. " + c2.sum(1, 5));

    // 3. 람다식
    Calculator c3 = (a, b) -> a + b;
    System.out.println("3. " + c3.sum(1, 5));
  }
}
