package advanced.ch18.sec10;

import java.io.Serializable;

// Serializable
// - 객체 직렬화 가능하도록 표시하는 인터페이스
// - 마커 인터페이스 (내부 메서드 없이 표시 역할만 함)

public class Member implements Serializable {

  // serialVersionUID
  // 직렬화 클래스의 버전 식별용 (권장)
  private static final long serialVersionUID = 1L;

  private String name;
  private int age;

  // transient: 직렬화 제외대상 지정 키워드 -> 'null'로 저장됨
  private transient String password;

  public Member(String name, int age, String password) {
    this.name = name;
    this.age = age;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Member{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", password='" + password + '\'' +
            '}';
  }
}
