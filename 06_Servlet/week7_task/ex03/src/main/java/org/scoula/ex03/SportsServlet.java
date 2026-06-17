package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //MIME 타입 설정
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    String[] sports = request.getParameterValues("sports");
    String sex = request.getParameter("sex");

    // 자바 I/O
    PrintWriter out = response.getWriter();

    // html 작성
    out.println("<html><body>");
    for (String sport : sports) {
      out.print("좋아하는 운동: " + sport + "<br>");
    }
    out.print("성별: " + sex + "<br>");
    out.println("</body></html>");
  }
}