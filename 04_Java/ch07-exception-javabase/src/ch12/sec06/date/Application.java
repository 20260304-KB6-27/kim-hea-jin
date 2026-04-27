package ch12.sec06.date;

// java.util 대신 java.time 권장
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Application {
  public static void main(String[] args) {

//    Date date = new Date();  // 구버전
//
//    date.setYear(0);  // 1900
//
//    System.out.println("date = " + date);

    // LocalTime: 시간 표현 클래스
    // 시:분:초
    LocalTime timeNow = LocalTime.now();
    System.out.println("timeNow = " + timeNow);

    // LocalDate: 날짜 표현 클래스
    // 연도-월-일
    LocalDate dateNow = LocalDate.now();
    System.out.println("dateNoe = " + dateNow);
    // 날짜지정 가능
    LocalDate dateNow2 = LocalDate.of(2025, 4, 23);
    System.out.println("dateNow2 = " + dateNow2);

    // ZoneDateTime
    // 날짜, 시간, 시간대 표현 클래스
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println("zonedDateTime = " + zonedDateTime);

    // LocalDateTime (가장 많이 사용)
    // 날짜, 시간 표현 클래스
    // 연-월-일T시:분:초
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("localDateTime = " + localDateTime);
  }
}
