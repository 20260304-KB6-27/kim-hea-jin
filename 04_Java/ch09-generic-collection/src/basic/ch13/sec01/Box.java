package basic.ch13.sec01;

public class Box<T> {

  // 제네릭
  // - 제네릭 설정은 클래스명 뒤에 다이아몬드 연산자를 이용해 작성
  // - 연산자 내부의 영문자는 대문자로 작성 (관례)
  // 정의
  // - 데이터 타입 일반화

  public T content;

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }
}
