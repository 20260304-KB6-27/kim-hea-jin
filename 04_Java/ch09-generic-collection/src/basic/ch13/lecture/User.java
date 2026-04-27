package basic.ch13.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private String name;
  private Integer age;
}
