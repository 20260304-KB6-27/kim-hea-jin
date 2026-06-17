package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
  ServletContext sc;

  /*
  EL Scope

  - 탐색순서: page -> request -> session -> Application
  - EL은 내부적으로 getter 메서드 사용해 객체의 프로퍼티에 접근

   */
  @Override
  public void init(ServletConfig config) throws ServletException {
    sc = config.getServletContext();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

    sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope

    // Session 생성 후 Session Scope에 데이터 담기
    HttpSession session = req.getSession(); // Session Scope

    session.setAttribute("scopeName", "sessionScope 값");

    // RequestScope에 데이터 담기
    req.setAttribute("scopeName", "requestScope 값"); // Request Scope

    Member member = new Member("홍길동", "hong");

    req.setAttribute("member", member);  // 객체상태로 담아 전달 가능

    // 데이터 넘기기
    req.getRequestDispatcher("scope.jsp").forward(req, res);
  }
}