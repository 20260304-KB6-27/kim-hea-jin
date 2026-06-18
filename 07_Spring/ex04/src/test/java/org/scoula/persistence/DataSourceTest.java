package org.scoula.persistence;

import java.sql.Connection;
import javax.sql.DataSource;

// JUnit 5 및 Spring Test 관련 import
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 설정 클래스 및 로깅 import
import org.scoula.config.RootConfig;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class) // JUnit 5용 스프링 테스트 환경 실행
@ContextConfiguration(classes = {RootConfig.class}) // RootConfig의 빈 설정 정보 로드
@Log4j2
public class DataSourceTest {

  // 스프링 컨테이너가 생성한 DataSource 빈을 자동으로 주입(DI) 받음
  @Autowired
  private DataSource dataSource;

  @Test
  public void testConnection() {
    // dataSource 객체가 잘 주입되었는지 1차 확인
    Assertions.assertNotNull(dataSource, "DataSource 빈이 주입되지 않았습니다.");

    try (Connection con = dataSource.getConnection()) {
      // HikariCP 정보 및 실제 연결 객체 로그 출력
      log.info("HikariCP DataSource: " + dataSource);
      log.info("HikariCP Connection: " + con);

      // DB 연결 객체가 null이 아닌지 최종 확인
      Assertions.assertNotNull(con);
    } catch (Exception e) {
      Assertions.fail(e.getMessage());
    }
  }
}