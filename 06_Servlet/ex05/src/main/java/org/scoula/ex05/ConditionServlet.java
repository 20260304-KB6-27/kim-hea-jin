package org.scoula.ex05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/jstl")
public class ConditionServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String scoreStr = request.getParameter("score");

    int score = 0;

    if (scoreStr != null && !scoreStr.trim().isEmpty()){
      score = Integer.parseInt(scoreStr);  // 값 변경
    }

    request.setAttribute("score", score);  // 값 넘겨줌

    RequestDispatcher rd = request.getRequestDispatcher("jstl/condition.jsp");
    rd.forward(request, response);  // forward 통해 지정 jsp로 값 넘김
  }
}