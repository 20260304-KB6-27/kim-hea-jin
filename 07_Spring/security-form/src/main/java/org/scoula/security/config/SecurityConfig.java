package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/*
Spring Security의 보안 설정 클래스
 */
@Configuration
@EnableWebSecurity  // 필터체인 활성화
@RequiredArgsConstructor
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  // 문자셋 필터
  public CharacterEncodingFilter encodingFilter() {
    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
    encodingFilter.setEncoding("UTF-8");
    encodingFilter.setForceEncoding(true);
    return encodingFilter;
  }

  // CSRF 공격: 로그인한 사용자를 악의적인 사이트로 몰래 요청을 보내게 하는 공격
  // Security 세팅할 공간
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // CSRFfilter(CSRF 공격 예방) 앞에 encodingFilter 위치
    http.addFilterBefore(encodingFilter(), CsrfFilter.class);  // 필터 추가

    // URL별 접근 권한 설정
    http.authorizeRequests()
            // 모든 권한 접근 허용
            .antMatchers("/security/all").permitAll()
            // 관리자만 접근 허용
            .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
            // 회원, 관리자만 접근 허용
            .antMatchers("/security/member").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')");

    // form 기반 로그인 활성화
    http.formLogin()
            .loginPage("/security/login")  // 로그인 페이지 커스텀
            .loginProcessingUrl("/security/login")  // spring 기본제공 POST 요청 시 로그인 시도
            .defaultSuccessUrl("/");  // 성공시 index.jsp로 이동

    http.logout()
            .logoutUrl("/security/logout")  // POST 요청 보내변 로그아웃 시고
            .invalidateHttpSession(true)  // 세션 초기화
            .deleteCookies("JSESSION-ID")  // 쿠키 삭제
            .logoutSuccessUrl("/security/logout");  // 성공시 logout.jsp로 이동
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      // 테스트용으로 메모리 상에 사용자 정보 등록
//    // 관리자 계정
//    auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password("$2a$10$3nadRHw7U6fu3QHgZhI/8.I8BC3bbMiUZ6SU8cyYi.AxgquyHWM52")  // 암호화O
//            .roles("ADMIN", "MEMBER");
//
//    // 일반 계정
//    auth.inMemoryAuthentication()
//            .withUser("member")
//            .password("{noop}1234")  // {noop}: 비밀번호 암호화 무시, 암호화X -> 승인X
//            .roles("MEMBER");

    // 요청 들어올 때 인증 처리 커스텀
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());  // 사용자 입력 - DB 비교
  }

  @Bean
  public PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
  }
}

