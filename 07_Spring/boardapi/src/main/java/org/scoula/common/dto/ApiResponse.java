package org.scoula.common.dto;

import lombok.Builder;
import lombok.Getter;

/* 공통 응답 래퍼 패턴
RESTAPI는 앤드포인트마다 성공/예외에 대한 응답 구조가 달라져 FrontEnd에서 처리하기 어려움
-> 동일한 구조로 감싸(래핑) client가 성공여부를 쉽게 판단할 수 있도록 함
 */
@Getter
@Builder
public class ApiResponse<T> {  // 공통응답객체 -> 제네릭 타입 T

  private boolean success; // 성공여부
  private String message;  // 성공시 "success" 실패시 에러 메시지
  private T data;  // 실제 응답 데이터

  // 성공
  // <T>: 제네릭 타입이 있음을 compiler에게 알려주는 역할
  public static <T> ApiResponse<T> ok(T data) {
    return ApiResponse.<T>builder()
            .success(true)
            .message("success")
            .data(data)
            .build();
  }

  // 실패
  public static <T> ApiResponse<T> fail(String message) {
    return ApiResponse.<T>builder()
            .success(false)
            .message(message)
            .data(null)
            .build();
  }
}
