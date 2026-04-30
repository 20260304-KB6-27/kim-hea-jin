package lecture.section;

import java.util.List;
import java.util.Optional;

// DB 조회
public class UserService {

  // Repository 주입
  private final UserRepository repository = new UserRepository();

  public List<User> getUsers() {

    // 비즈니스 로직
    List<User> users = repository.findAll();

    return users;
  }

  public User getUserById(long l) {

    // Optional<User>
    // 값이 없을때 예외 처리
    User user = repository.findById(l)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다. id = " + l));
    return user;
  }

  // ifPresent -> 값 없으면 실행
  public void printIfExist(long l) {

    repository.findById(l)
            .ifPresent(u -> System.out.println("user = " + u));
  }

  public String getEmail(long l) {
    return repository.findById(l)
            // findById -> Optional<User> -> getEmail -> Optional<Optional<String>>
            // 일반적인 getEmail 호출 시 Optional 중복 감싸짐
            // -> flatMap이용해 Optional 하나로 처리
            .flatMap(user -> Optional.ofNullable(user.getEmail()))
            .orElse("이메일 없음");  // email=null일 때 출력할 default값
  }
}
