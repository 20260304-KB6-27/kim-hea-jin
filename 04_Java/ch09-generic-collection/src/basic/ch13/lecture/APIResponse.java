package basic.ch13.lecture;

import lombok.ToString;

// generic 적용
@ToString
public class APIResponse<T> {
  private boolean success; // api 처리 성공 여부
  private T data;
  private String message;

  public APIResponse(boolean success, T data, String message) {
    this.success = success;
    this.data = data;
    this.message = message;
  }

  // 성공응답
  public static <T> APIResponse<T> ok(T data) {
    return new APIResponse<>(true, data, "요청 성공");
  }

  // 실패응답
  public static <T> APIResponse<T> fail(String message) {
    return new APIResponse<>(false, null, message);
  }
}
