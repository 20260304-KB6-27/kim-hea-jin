package org.scoula.security.config;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        RootConfig.class,
        SecurityConfig.class
})
@Log4j2
class SecurityConfigTest {

  @Autowired
  private PasswordEncoder pwEncoder;

  @Test
  void passwordEncoder() {
    String str = "1234";

    String enStr = pwEncoder.encode(str); // 문자열 암호화
    String enStr2 = pwEncoder.encode(str); // 문자열 암호화(enStr와 다름)

    log.info("암호화된 password: {}", enStr);

    log.info("match: {}", pwEncoder.matches(str, enStr));  // 암호화 전 후 문자열 비교
    // match: true 출력됨
  }
}