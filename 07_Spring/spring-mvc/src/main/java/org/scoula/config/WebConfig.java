package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    final String LOCATION = "c:/upload"; // 업로드 처리할 디렉토리 경로
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L; // 업로드 가능한 하나의 파일 크기
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 10L; // 업로드 가능한 전체 최대 크기
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5; // 메모리파일의 최대 크기

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // 기본적으로 반환하는 404 NOT FOUND을 전송하지 않고,
        // 예외(NoHandlerFoundException)를 던지도록 함
        registration.setInitParameter("ThrowExceptionIfNoHandlerFound", "true");

        // 멀티파트 파일 기능 설정
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                LOCATION,MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD
        );

        registration.setMultipartConfig(multipartConfigElement);
    }
}
