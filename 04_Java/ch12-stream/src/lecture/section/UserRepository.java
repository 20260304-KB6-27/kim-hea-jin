package lecture.section;

import java.util.List;
import java.util.Optional;

public class UserRepository {
  private static final List<User> DB = List.of (
          new User(1L, "KIM", "abc@gmail.com"),
          new User(2L, "LEE", null),
          new User(3L, "AAA", "def@gmail.com"),
          new User(4L, "BBB", "ghi@gmail.com")
  );

  // query
  public List<User> findAll() { return DB; }

  // 단일조회
  // Optional: null인 경우 처리위함
  public Optional<User> findById(Long id) {

    // null -> Optional.empty() return
    return DB.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();  // 첫번째로 일치하는 값 반환
  }
}
