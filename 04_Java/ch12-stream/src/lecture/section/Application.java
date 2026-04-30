package lecture.section;

import java.util.List;

public class Application {
  public static void main(String[] args) {

    // 주입
    UserService service = new UserService();

    List<User> users = service.getUsers();
    users.forEach(u -> System.out.println(users));

    // 단일조회
    User user = service.getUserById(1L);
    System.out.println(user);

    // null 유저 조회 (예외 처리)
    User user2 = null;
    try {
      user2 = service.getUserById(99L);
    } catch (Exception e) {
      System.out.println("[예외] : " + e.getMessage());
    }

    // id=3L인 유저 조회
    service.printIfExist(3L);

    // email 조회
    String email = service.getEmail(1L);
    String email2 = service.getEmail(2L);  // email=null
    System.out.println(email);
    System.out.println(email2);  // default: 이메일 없음 출력



  }
}
