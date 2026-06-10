package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PerformanceMonitorFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    String url = req.getRequestURI();

    // 1. 요청 접수 시간 기록 (현재 시각 및 밀리초)
    long startTime = System.currentTimeMillis();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTime = now.format(formatter);

    // 2. 다음 필터 또는 서블릿으로 요청 전달
    chain.doFilter(request, response);

    // 3. 서블릿 처리가 모두 끝난 후 복귀했을 때 수행 시간 계산
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;

    // 4. 로그 출력
    System.out.println("[" + formattedTime + "] " + url + " - " + duration + "ms 소요.");
  }
}
