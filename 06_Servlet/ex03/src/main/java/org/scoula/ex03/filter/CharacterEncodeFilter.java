package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
Filter
- 클라이언트 요청이 Servlet/JSP에 도착하기 전, 응답이 나가기 전에 공동처리할 수 있는 컴포넌트
 */

// filter 등록
// filter의 동작 순서 보장X (순서 알 수 없음)
//@WebFilter(urlPatterns = {"/*"})  // 모든 요청이 filter 거치도록 함
public class CharacterEncodeFilter implements Filter {

  // filter 생성 시 동작
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    // 1. Servlet 호출 전 (전처리)
    System.out.println("필터 동작 시작");

    // body 한글 깨짐 방지
    request.setCharacterEncoding("UTF-8");

    // 2. 다음 filter 또는 servlet으로 요청 전달
    chain.doFilter(request, response);

    // 3. Client 응답 전 (후처리)
    System.out.println("필터 동작 끝");
  }

  // 서버 종료 시 호출
  @Override
  public void destroy() {
  }
}
