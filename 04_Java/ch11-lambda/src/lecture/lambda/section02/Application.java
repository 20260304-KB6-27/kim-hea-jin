package lecture.lambda.section02;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Application {
  public static void main(String[] args) {

    // Runnable: 매개변수X, 리턴값X : run()
    // Consumer: 매개변수O, 리턴값X : accept()
    // Supplier: 매개변수X, 리턴값O : getXXX()
    // Function: 매개변수O, 리턴값O : apply()
    // Operator: 매개변수O, 리턴값O : apply() 매개변수, 리턴 타입 동일
    // Predicate: 매개변수O, 리턴값O : test() Boolean값 리턴

    BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;

    System.out.println("binaryOperator 실행: " + binaryOperator.apply(1, 5));

    // Runnable
    Runnable runnable = () -> System.out.println("runnable 실행");
    runnable.run();

    // Consumer
    Consumer<String> consumer = (String str) -> System.out.println(str);
    consumer.accept("consumer 실행");

    // Supplier<ReturnType>
    Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
    System.out.println("supplier 실행: " + supplier.get());

    // Function<매개변수타입, 리턴타입>
    Function<String, Integer> function = (String str1) -> Integer.parseInt(str1);
    String str = "12345";
    System.out.println("function 실행: " + function.apply(str));

    // Predicate<매개변수타입>
    Predicate<Integer> isEven = n -> n % 2 == 0;
    System.out.println("predicate 실행: " + isEven.test(5));

    // Stream
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    List<Integer> numbers2 = numbers.stream()
                                    .filter(isEven)
                                    .toList();

    // 짝수만 추출
    System.out.println(numbers2);
  }
}
