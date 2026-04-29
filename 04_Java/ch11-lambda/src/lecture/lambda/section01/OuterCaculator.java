package lecture.lambda.section01;

public interface OuterCaculator {

  // 내부 인터페이스
  // - 기본적으로 public static 속성 가짐
  // - 바깥인터페이스명.내부인터페이스명으로 접근
  @FunctionalInterface
  public interface Sum {
    int sum(int a, int b);
  }

  @FunctionalInterface
  public interface Minus {
    int sum(int a, int b);
  }

  @FunctionalInterface
  public interface Multiple {
    int sum(int a, int b);
  }

  @FunctionalInterface
  public interface Devide {
    int sum(int a, int b);
  }
}
