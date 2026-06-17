package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //MIME 타입 설정
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    String userid = request.getParameter("userid");
    String passwd = request.getParameter("passwd");

    // 자바 I/O
    PrintWriter out = response.getWriter();

    // html 작성
    out.println("<html><body>");
    out.println("아이디 값: " + userid + "<br>");
    out.println("비밀번호 값: " + passwd + "<br>");
    out.println("</body></html>");
  }
}