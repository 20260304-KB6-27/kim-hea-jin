package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends HttpServlet {

  // URL과 command mapping: url 요청 들어올 때 동작할 메서드를 객체로 생성
  Map<String, Command> getMap;  // get 요청
  Map<String, Command> postMap;  // post 요청

  // jsp 경로 나타낼 접두어, 접미어 설정
  String prefix = "/WEB-INF/views/";
  String outfix = ".jsp";

  HomeController homeController = new HomeController();
  TodoController todoController = new TodoController();

  public void init() {
    getMap = new HashMap<>();
    postMap = new HashMap<>();

    // GET 요청 등록
//  getMap.put("/", ((request, response) -> homeController.getIndex(request, response)));
    getMap.put("/", homeController::getIndex);

    // GET 매핑
    getMap.put("/todo/list", todoController::getList);
    getMap.put("/todo/view", todoController::getView);
    getMap.put("/todo/create", todoController::getCreate);
    getMap.put("/todo/update", todoController::getUpdate);

    // POST 매핑
    postMap.put("/todo/create", todoController::postCreate);
    postMap.put("/todo/update", todoController::postUpdate);
    postMap.put("/todo/delete", todoController::postDelete);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    Command command = getCommand(request);

    if (command != null) {
      execute(command, request, response);
    } else {
      // 등록하지 않은 url로의 요청 -> 404.jsp
      // System.out.println("일치하는 페이지가 없습니다.");
      String view = prefix + "404" + outfix;
      request.getRequestDispatcher(view).forward(request, response);
    }

  }

  // request 객체에서 명령어에 해당하는 url 찾아오는 메서드
  private String getCommandName(HttpServletRequest request) {

    // 전체URL: localhost:8080/contextPath/command
    // requestURI: /contextPath/command
    String requestURI = request.getRequestURI();
    System.out.println("requestURI = " + requestURI);

    // contextPath
    String contextPath = request.getContextPath();
    System.out.println("contextPath = " + contextPath);

    // command
    String commandName = requestURI.substring(contextPath.length());
    System.out.println("commandName = " + commandName);

    return commandName;
  }

  // Map 안에서 command 꺼내오는 메서드
  private Command getCommand(HttpServletRequest request) {

    Command command;

    String commandName = getCommandName(request);

    // get/post 요청 구분
    if(request.getMethod().equalsIgnoreCase("GET")) {
      // get 요청
      command = getMap.get(commandName);
    } else {
      // post 요청
      command = postMap.get(commandName);
    }
    return command;
  }

  // 매개변수로 받은 command에 request, response를 담에 실행 (비즈니스 로직)
  // command 실행시켜 forward할 jsp 파일의 경로 전달
  public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    // 요청받은 jsp 파일 이름
    String viewName = command.execute(request, response);
    // System.out.println("viewName = " + viewName);

    if (viewName.startsWith("redirect:")) {
      // redirect
      response.sendRedirect(viewName.substring("redirect:".length()));
    } else {
      // forward

      // jsp 파일 경로 설정
      String view = prefix + viewName + outfix;

      request.getRequestDispatcher(view).forward(request, response);
      // request.getRequestDispatcher("/WEB-INF/views/index.jsp");
    }



  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp); // doPost() 호출 시 doGet()으로 전달
  }
}