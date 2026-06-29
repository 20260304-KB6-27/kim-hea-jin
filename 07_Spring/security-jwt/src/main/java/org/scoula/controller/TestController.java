package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Log4j2
@RequestMapping("/member")
public class TestController {

  @GetMapping("")
  public String test() {
    return "CORS Problem Test";
  }

  /*
  [인증 객체 꺼내는 방법]
  1. Principal: username만 꺼낼 수 있음
  2. Authentication: 권한, 인증 상태 등 Security 정보 필요할 때, UserDetail로 형변환 필요
  3. @AuthenticationPrincipal: CustomUser에 바로 접근 가능 (주로 사용)
   */

  // 1. Principal
  @GetMapping("/1")
  public String print1(Principal principal) {
    return principal.getName();  // username 출력
  }

  // 2. Authentication
  @GetMapping("/2")
  public String print2(Authentication authentication) {
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return userDetails.getUsername();  // username 출력
  }

  // 3. @AuthenticationPrincipal
  @GetMapping("/3")
  public MemberVO print3(@AuthenticationPrincipal CustomUser customUser) {
    MemberVO memberVO = customUser.getMemberVO();
    return memberVO;  // user정보(memberVO) 출력
  }
}
