package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //MIME 타입 설정
    response.setContentType("text/html; charset=UTF-8");

    // 자바 I/O
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession(false);

    out.println("<html><body>");
    out.println("장바구니 리스트");

    if (session != null) {
      session.setMaxInactiveInterval(20);

      ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
      out.println("상품: " + list + "<br>");
    } else {
      out.println("세션 없음" + "<br>");
    }

    out.println("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
    out.println("<a href='cart_delete'>장바구니 비우기</a><br>");
    out.println("</body></html>");
  }
}