package org.scoula.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testConnection() {
    try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/scoula_db?serverTimezone=Asia/Seoul",
            "scoula",
            "1234")) {
      log.info("JDBC Connection: " + con);
    } catch (Exception e) {
      Assertions.fail(e.getMessage());
    }
  }
}