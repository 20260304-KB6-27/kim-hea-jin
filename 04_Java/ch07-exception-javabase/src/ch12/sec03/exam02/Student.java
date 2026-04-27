package ch12.sec03.exam02;

import lombok.*;

// DTO: 데이터 전달용 객체
// Getter, Setter, NoArgsConstructor, AllArgsConstructor, ToString
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString

@Data // Getter, Setter, ToString, EqualHashCode, RequiredArgsConstructor
@AllArgsConstructor
public class Student {

  private int no;
  private String name;
}