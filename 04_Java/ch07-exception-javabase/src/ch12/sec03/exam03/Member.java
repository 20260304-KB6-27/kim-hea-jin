package ch12.sec03.exam03;

public record Member(String id, String name, int age) {

  // record compiler가 자동생성 (주로 DTO 만들 때 사용)
  // 매개변수 -> private final field (수정 불가, setter() 없음)
  // 모든 field 받는 constructor
  // getter() -> 필드명으로 생성
  // toString(), hashCode(), equals()
  // 상속 불가
}
