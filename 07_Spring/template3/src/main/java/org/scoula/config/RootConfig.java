package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// Data Source 설정
// - application.properties에서 driver, url, username, password 읽어옴
@PropertySource("classpath:/application.properties")
// org.scoula.mapper 내부 파일 읽어옴
@MapperScan(basePackages = {"org.scoula.mapper"})
public class RootConfig {

  @Value("${jdbc.driver}")
  private String driver;

  @Value("${jdbc.url}")
  private String url;

  @Value("${jdbc.username}")
  private String username;

  @Value("${jdbc.password}")
  private String password;

  @Autowired
  ApplicationContext applicationContext;

  /*
  SQL SessionFactory
  - Mybatis Factory 객체를 스프링 컨테이너에 등록
  */
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

    // mybatis global 설정
    sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));

    // db 연결 설정
    sqlSessionFactory.setDataSource(dataSource);

    return sqlSessionFactory.getObject();
  }

  /*
  트랜잭션 매니저
  - Spring에서 DB 트랜잭션을 관리하기 위함
   */
  @Bean
  public DataSourceTransactionManager transactionManager() {
    DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
    return manager;
  }

  /*
  HicariCP 커넥션 풀을 사용한 DataSource 빈 생성
  */
  @Bean
  public DataSource dataSource() {
    HikariConfig config = new HikariConfig();

    // db 연결정보 세팅
    config.setDriverClassName(driver);  // JDBC 드라이버 클래스
    config.setJdbcUrl(url);  // database URL
    config.setUsername(username);
    config.setPassword(password);

    // 커넥션 풀 설정
    config.setMaximumPoolSize(10);   // 최대로 가질 수 있는 커넥션 수
    config.setMinimumIdle(5);  // 최소 유지 커넥션 수
    config.setConnectionTimeout(30000);  // 연결 타임아웃 (30초)
    config.setIdleTimeout(600000);  // 유휴 타임아웃 (10분)

    HikariDataSource dataSource = new HikariDataSource(config);

    return dataSource;
  }
}
