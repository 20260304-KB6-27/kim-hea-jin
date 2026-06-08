package app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/*
POJO (Plan Old Java Object)
- 순수한 Java로 만들어진 객체 (외부 라이브러리 사용X)
- lombok은 단순히 자바로 이루어진 코드를 생성하므로 상관X
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
  private ObjectId id;  // mongodb에도 ID가 객체형태로 저장됨
  private String title;
  private String desc;
  private boolean done;
}
