package lecture.lambda.section01;

public class Application2 {
  public static void main(String[] args) {

    OuterCaculator.Sum sum = (x, y) -> x + y;
    OuterCaculator.Minus minus = (x, y) -> x - y;
    OuterCaculator.Multiple multiple = (x, y) -> x * y;
    OuterCaculator.Devide devide = (x, y) -> x / y;

    // 매개변수, 리턴값, 타입만 지정하면 같은 Sum interface 하나로 여러 함수 생성 가능
    // => 표준 API의 함수적 인터페이스 사용
  }
}
