package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DecoFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    String url = req.getRequestURI();

    // 1. 요청 처리 전 (서블릿 들어가기 전)
    System.out.println(url + " =======>");

    // 2. 다음 필터 또는 서블릿으로 이동
    chain.doFilter(request, response);

    // 3. 요청 처리 후 (서블릿에서 빠져나온 후)
    System.out.println("<=======");
  }
}
