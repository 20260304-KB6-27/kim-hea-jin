package ch12.annotation;

// 사용자 정의 어노테이션

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation: @ 기호로 시작하는 "메모 태그"
// - 클래스, 메소드, 필드 등에 붙여서 추가 정보 표시

// @Target
// - TYPE: 클래스, 인터페이스
// - FIELD: 멤버 변수
// - METHOD: 메서드

// @Retention
// - SOURCE: 컴파일 시 사라짐
// - CLASS: .Class 파일까지만 유지, 실행 중 사라짐
// - RUNTIME: 실핼 중에도 유지

// annotation 동작방식
// 1, 컴파일 단계: 컴파일러가 확인 (@override)
// 2. Runtime + Reflection: 런타임 중에 읽어서 동작 (@Autowired, @Controller, ..)
// 3. Annotation Processor: 컴파일 시 코드 생성 (@Getter, @Setter, ..)

@Target({ElementType.METHOD})  // annotation 붙일 수 있는 범위
@Retention(RetentionPolicy.RUNTIME)  // annotation 정보 유지기간
public @interface PrintAnnotation {

  // 속성: annotation에 값 전달 시 사용
  // default 속성은 값 생략가능

  String value() default "-";
  int number() default 15;
}
