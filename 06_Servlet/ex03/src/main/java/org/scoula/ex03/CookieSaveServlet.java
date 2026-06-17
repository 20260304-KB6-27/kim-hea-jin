package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/*
JSESSIONID가 담긴 공간, key: value 쌍으로 저장
쿠키 (Cookie)
 - key-value 쌍으로 client(browser)에 저장
 - 만료시간 지정 가능, 미지정 시 브라우저 종료시 삭제됨
 - 브라우저가 다음 요청을 보낼 때부터 http요청에 cookie 담아 전송
 */
@WebServlet("/cookie-save")
public class CookieSaveServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    //MIME 타입 설정
    response.setContentType("text/html; charset=UTF-8");

    // jsp에서 받아옴
    String value = request.getParameter("cookieValue");

    // 쿠키 객체 생성
    Cookie cookie = new Cookie("myCookieData", value);

    // 쿠키 만료 시간(초 단위) 설정
    cookie.setMaxAge(10);

    // 브라우저로 전송
    response.addCookie(cookie);

    // 자바 I/O
    PrintWriter out = response.getWriter();

    // html 작성
    out.println("<html><body>");
    out.println("<h2>Cookie 저장 결과</h2>");
    out.println("<h2>저장 요청한 값: " + value + "</h2>");
    out.println("<a href='session_cookie.jsp'>돌아가기</a>");
    out.println("</body></html>");
  }
}