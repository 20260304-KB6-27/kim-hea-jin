package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl2")
public class ForEachServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Member> members = new ArrayList<>();

    members.add(new Member("홍길동", "hong"));
    members.add(new Member("김", "kim"));
    members.add(new Member("이", "lee"));

    request.setAttribute("memberList", members);

    request.getRequestDispatcher("jstl/forEach.jsp").forward(request, response);
  }
}