package lecture.lambda.section01;

// 추상 메소드가 하나만 있는 인터페이스에서만 적용가능
@FunctionalInterface  // 컴파일 시 함수형 인터페이스 조건을 만족하는지 검증
public interface Calculator {

  public int sum(int a, int b);
}
