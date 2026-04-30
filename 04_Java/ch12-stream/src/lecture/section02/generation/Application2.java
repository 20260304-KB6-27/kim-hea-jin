package lecture.section02.generation;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
  public static void main(String[] args) {

    // range(시작값, 종료값): 시작값부터 1씩 증가하는 숫자들 범위의 스트림 생성 (종료값X)
    // rangeClosed(시작값, 종료값): 종료값 포함 스트림 생성

    IntStream intStream = IntStream.range(5, 10);
    intStream.forEach(i -> System.out.print(i + " "));

    System.out.println();

    IntStream intStream2 = IntStream.rangeClosed(5, 10);
    intStream2.forEach(i -> System.out.print(i + " "));

    System.out.println();

    // doubles(n): n개의 난수 스트림 생성
    // boxed(): 기본타입 스트림 박싱해 Stream<타입> 반환
    Stream<Double> doubleStream = new Random().doubles(5).boxed();
    DoubleStream doubleStream2 = new Random().doubles(5);

    doubleStream.forEach(d -> System.out.print(d + " "));
    System.out.println();
    doubleStream2.forEach(d -> System.out.print(d + " "));

    // of()
    Stream<String> stringStream1 = Stream.of("java", "mysql", "jdbc");
    Stream<String> stringStream2 = Stream.of("html", "css", "js");

    System.out.println();
    stringStream1.forEach(System.out::println);

    // concat을 이용해 두 stream을 동일타입 stream으로 합칠 수 있음
    Stream<String> concatStream = Stream.concat(stringStream1, stringStream2);
    concatStream.forEach(System.out::println);
  }
}
