package org.scoula.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties") // resources 폴더 안의 application.properties 로드
public class RootConfig {

  // application.properties에 작성한 키(Key) 이름과 매핑하여 값을 주입받음
  @Value("${jdbc.driver}")
  private String driver;

  @Value("${jdbc.url}")
  private String url;

  @Value("${jdbc.username}")
  private String username;

  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    // 1. HikariCP 설정을 위한 Config 객체 생성
    HikariConfig hikariConfig = new HikariConfig();

    // 2. 주입받은 필드값들을 HikariConfig에 세팅
    hikariConfig.setDriverClassName(driver);
    hikariConfig.setJdbcUrl(url);
    hikariConfig.setUsername(username);
    hikariConfig.setPassword(password);

    // 3. 설정을 기반으로 생성된 구체적인 커넥션 풀 객체(HikariDataSource)를 반환
    return new HikariDataSource(hikariConfig);
  }
}