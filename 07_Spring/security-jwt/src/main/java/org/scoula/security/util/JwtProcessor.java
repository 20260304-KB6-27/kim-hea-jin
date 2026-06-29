package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@PropertySource("classpath:/application.properties")
public class JwtProcessor {

  static private final long TOKEN_VALID_MILLISECOND = 1000L * 60 * 5;  // 만료 시간: 5분

  // 서명용 키
  private final Key key;

  public JwtProcessor(@Value("${jwt.secret}") String key) {

    // 32byte 이상
    this.key = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
  }

  // JWT 발급
  public String generateToken(String subject) {
    return Jwts.builder()
            .setSubject(subject)  // 사용자 식별값 삽입(사용자 ID, 이메일 등)
            .setIssuedAt(new Date())  // 발급 시간
            .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILLISECOND))  // 만료시간
            .signWith(key)
            .claim("key", "value")  // 커스텀 삽입 가능
            .compact();  // 하나의 문자열로 반환
  }

  // JWT에서 username(PK) 추출
  public String getUsername(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)  // token 파싱
            .getBody()
            .getSubject();
  }

  // JWT 검증 (유효기간, 서명 검증)
  public boolean validateToken(String token) {
    // JWS: 서명, 만료일 검증하는 로직 포함됨
    Jws<Claims> claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);

    return true;
  }
}
