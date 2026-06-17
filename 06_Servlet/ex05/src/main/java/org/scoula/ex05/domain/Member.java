package org.scoula.ex05.domain;

public class Member {
  private String name;
  private String userid;

  public Member() {

  }

  public Member(String userid, String name) {
    this.userid = userid;
    this.name = name;
  }

  // --- 추가된 Getter 메서드 (EL이 값을 읽을 때 사용) ---
  public String getName() {
    return name;
  }

  public String getUserid() {
    return userid;
  }

  // --- 추가된 Setter 메서드 ---
  public void setName(String name) {
    this.name = name;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }
}