package org.scoula.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  // 메소드 단위 매핑
  @GetMapping("/")
  public String getIndex() {
    return "index";
  }

}
