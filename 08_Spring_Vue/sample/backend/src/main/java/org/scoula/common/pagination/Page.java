package org.scoula.common.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)  // 생성자를 내부에서만 호출 가능
public class Page<T> {
  private int totalCount;  // 전체 데이터 개수
  private int totalPage;  // 전체 데이터 개수
  private List<T> list;  // 페이징된 데이터 목록

  @JsonIgnore  // JSON 직렬화 제외
  private PageRequest pageRequest;  // 내부 계산용 (getPageNum, getAmount)를 하기위한 용도

  // 페이지 객체 생성용 정적 메서드
  public static <T> Page of(PageRequest pageRequest, int totalCount, List<T> list) {

    // 총 페이지 개수 계산용
    int totalPage = (int)Math.ceil((double) totalCount / pageRequest.getAmount());

    return new Page(totalCount, totalPage, list, pageRequest);
  }

  // 현재 페이지 번호 반환
  public int getPageNum() { return pageRequest.getPage();}

  // 페이지 당 데이터 개수 반환
  public int getAmount() { return pageRequest.getAmount();}
}
