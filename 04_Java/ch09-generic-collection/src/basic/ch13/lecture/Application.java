package basic.ch13.lecture;

// backend로 api 요청 보낸후 응답 받는 "공동 응답 객체" 생성

public class Application {
  public static void main(String[] args) {
    // 요청이 들어온 상태

    // 서비스 로직
    User user = new User("kim", 20);
    System.out.println(user);

    // Controller
    APIResponse<User> response = APIResponse.ok(user);

    // API 요청한 곳에서 응답받는 객체
    System.out.println(response);
  }


//  @GetMapping("/user/1")
//  public APIResponse<User> getUser() {
//    User user = new User("kim", 20);
//    return APIResponse.ok(user);
//  }
}
