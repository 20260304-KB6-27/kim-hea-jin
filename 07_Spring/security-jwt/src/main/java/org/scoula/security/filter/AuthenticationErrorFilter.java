package org.scoula.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// filter에서 발생한 예외 처리
// JWT 인증 예외 처리 필터
@Component
public class AuthenticationErrorFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      // 다음 순서의 필터에서 예외 발생 시 이 위치에서 에외 처리
      super.doFilter(request, response, filterChain);
    } catch (ExpiredJwtException e) {  // 토큰 만료
      // 토큰 재발급 로직 추가 가능
      JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, "토큰의 유효시간이 만료됨");
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {  // 지원하지 않는 형식 or 구조 깨짐 (401)
      JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, e.getMessage());
    } catch (JwtException e) {  // 그 외 모든 JWT 관련 예외 (401)
      JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, e.getMessage());
    } catch (ServletException e) {  // 그 외 서블릿 레벨 예외 (500)
      JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, e.getMessage());
    }
  }
}
