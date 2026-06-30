package org.scoula.security.filter;

import lombok.RequiredArgsConstructor;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// request에 JWT가 담겨왔을 때 검증하고 securityContext에 유저정보(userDetail)를 담아주는 필터
// OncePerRequestFilter: 1번의 요청에 1번만 작동하는 filter
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  //JWT가 담겨있을 key(header)
  public static final String AUTHORIZATION_HEADER = "Authorization";
  // Bearer 토큰을 가진 유저에게 권한 부여 -> Bearer [JWT] 형식으로 전달됨
  public static final String BEARER_PREFIX = "Bearer";

  private final JwtProcessor jwtProcessor;  // 토큰 검증용
  private final UserDetailsService userDetailsService;  // 사용자 조회용

  // 검증 메서드
  private Authentication getAuthentication(String token) {

    // token에서 username 꺼내오고 sign 검증
    String username = jwtProcessor.getUsername(token);

    // UserDetail 객체 생성 (db에서 username 찾아서 유저 데이터 넣음)
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

    // 유저정보, 비밀번호, 권한 담긴 객체 전달
    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    // request -> jwt 꺼내기
    String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

    // 토큰 존재 & Bearer로 시작하는 JWT 처리
    if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)){
      // prefix 지우기 (Bearer 키워드 제거) -> 순수 JWT만 남음
      String token = bearerToken.substring(BEARER_PREFIX.length());

      // token -> Authentication 객체로 변환 후 SecurityContext에 저장
      Authentication authentication = getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // 상속클래스이므로 부모의 매개변수 전달
    super.doFilter(request, response, filterChain);  // 다음 filter로 넘기기
  }
}
