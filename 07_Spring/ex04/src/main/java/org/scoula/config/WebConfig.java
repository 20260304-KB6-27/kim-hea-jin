package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.InputStream;
import java.util.Properties;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

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
        // 대소문자 구분을 위해 throwExceptionIfNoHandlerFound 로 수정 (t 소문자 권장)
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        // application.properties 파일에서 설정값 읽어오기
        Properties props = new Properties();
        try (InputStream is = getClass().getResourceAsStream("/application.properties")) {
            props.load(is);

            // 프로퍼티 값을 읽어오고, 만약 값을 찾지 못할 경우의 기본값(두 번째 파라미터) 설정
            String location = props.getProperty("upload.location", "c:/upload");
            long maxFileSize = Long.parseLong(props.getProperty("upload.maxFileSize", "-1"));
            long maxRequestSize = Long.parseLong(props.getProperty("upload.maxRequestSize", "-1"));
            int fileSizeThreshold = Integer.parseInt(props.getProperty("upload.fileSizeThreshold", "5242880"));

            MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                    location, maxFileSize, maxRequestSize, fileSizeThreshold
            );

            registration.setMultipartConfig(multipartConfigElement);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("application.properties에서 파일 업로드 설정을 불러오는데 실패했습니다.", e);
        }
    }
}