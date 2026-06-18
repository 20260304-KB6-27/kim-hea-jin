package org.scoula.board.domain;

import lombok.*;

import java.util.Date;

// Mybatis에서 VO: DB 테이블 한 행에 매핑되는 객체
@Data  // GETTER, SETTER, ToString, EqualsAndHashCode, RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
  private Long no;
  private String title;
  private String content;
  private String writer;
  private Date regDate;
  private Date updateDate;
}
