package org.scoula.ex05;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    // index.jsp에서 받아옴
    String name = request.getParameter("name");

    // request scope
    request.setAttribute("username", name);  // request에 데이터 담음

    if (name != null && !name.isEmpty()) {
      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/helloView.jsp");  // 데이터 전달할 jsp파일 경로 설정

      rd.forward(request, response);  // 지정한 경로로 request, response 전달
    } else {
      // redirect: response를 바로 client에게 넘겨줌 (지정한 경로로 이동)
      response.sendRedirect("http://localhost:8080/WEB-INF/views/helloView.jsp");  // 404 에러
    }
  }

}