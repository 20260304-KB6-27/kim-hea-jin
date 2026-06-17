package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws IOException, ServletException {
    // 응답 데이터의 MIME 타입 설정
    resp.setContentType("text/html;charset=UTF-8");

    // PrintWriter 획득
    PrintWriter out = resp.getWriter();

    // HTML 작성 및 출력
    out.print("<html><body>");
    out.print("ResponseServlet 요청 성공");
    out.print("</body></html>");
  }
}