package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

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

  @Autowired
  private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

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

    // CSRFFilter(CSRF 공격 예방) 앞에 encodingFilter 위치
    http.addFilterBefore(encodingFilter(), CsrfFilter.class)  // 필터 추가
            .addFilterAfter(jwtUsernamePasswordAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class);

    // CORS 설정 추가
    http.cors();

    http
            .httpBasic().disable()  // 기본 HTTP 인증 비활성화
            .csrf().disable()  // csrf 비활성화
            .formLogin().disable()  // form login 비활성화
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // 세션 생성X

    // URL별 접근 권한 설정
    http.authorizeRequests()
            // 모든 권한 접근 허용
            .antMatchers("/security/all").permitAll()
            // 관리자만 접근 허용
            .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
            // 회원, 관리자만 접근 허용
            .antMatchers("/security/member").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // 요청 들어올 때 인증 처리 커스텀
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());  // 사용자 입력 - DB 비교
  }

  // 커스텀 하기위한 Authentication 객체를 bean으로 등록
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  // 인증 인가 제외 URL (security filter 통과X)
  // 일반적으로 보안 검사가 필요없는 정적 리소스 또는 특정 API는 Security Filter Chain을 거치지 않도록 설정
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
            .antMatchers(
                    "/assets/**",
                    "/*",  // 루트 경로 바로 아래 (/login, /member)
                    "/api/member/**"  // api/member 하위 경로
            );
  }

  @Bean
  public PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();  // CORS 설정 객체

    // 허용할 origin(출처) 목록
//    configuration.setAllowedOriginPatterns(Arrays.asList("*"));  // 모든 출처 허용
    configuration.setAllowedOriginPatterns(Arrays.asList("http://127.0.0.1:5500"));  // http://127.0.0.1:5500에서의 요청만 허용

    // 허용할 HTTP 메소드 목록
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

    // 모든 요청헤더 허용
    configuration.setAllowedHeaders(Arrays.asList("*"));

    // 쿠키, Authorization 헤더 등 자격증명 포함한 요청 허용
    configuration.setAllowCredentials(true);

    // 특정 URL 경로 패턴에 대해 CORS 설정 적용 (모든 요청에 CORS 설정 적용)
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;  // Security 필터 체인에서 사용
  }
}

