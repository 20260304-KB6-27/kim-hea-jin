package lecture.lambda.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Application2 {

  // 생성자 메소드 참조
  public static void main(String[] args) {

    List<String> subjects = new ArrayList<>();
    subjects.add("java");
    subjects.add("mysql");
    subjects.add("jdbc");
    subjects.add("html");
    subjects.add("css");


    Function<String, Account> function = (name) -> new Account(name);
    Account account = function.apply("홍길동");

    List<Account> accounts = subjects.stream()
            .map(Account::new)  // String -> Account 생성자 호출 (생성자 참조)
            .toList();
  }
}
