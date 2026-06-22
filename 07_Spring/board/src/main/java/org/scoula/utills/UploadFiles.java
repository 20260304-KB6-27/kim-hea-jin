package org.scoula.utills;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {

  public static String upload(String baseDir, MultipartFile part) throws IOException {

    File base = new File(baseDir);

    // 예외처리: 디렉토리 없으면 생성
    if (!base.exists()) {
      base.mkdir();  // 디렉토리 생성
    }

    // 원본 파일명(사용자가 지정) 가져오기 -> 파일명 중복 가능 -> 예외처리 (UUID 또는 원본파일명+올린시간으로 파일명 변경)
    // 원본 파일명은 DB에 저장(다운받을 때 사용)
    String filename = part.getOriginalFilename();

    // 저장할 파일 객체 생성
    // org/scoula/config/UploadFileName.java에서 고유한 파일명 생성
    File dest = new File(baseDir, UploadFileName.getUniqueName(filename));

    // 업로드 된 파일을 실제 서버 디렉토리에 저장 (물리 파일 생성)
    part.transferTo(dest);

    return dest.getPath();  // 저장된 파일 경로
  }

  // size long -> 문자열로 포맷팅해서 보여주는 메서드
  public static String getFormatSize(Long size) {
    if (size <= 0)
      return "0";
    final String[] units = new String[] { "Bytes", "KB", "MB", "GB", "TB" };
    int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
    return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
  }

  public static void download(HttpServletResponse response, File file, String orgname) throws IOException {

    response.setContentType("application/download");  // 응답으로 보내는 데이터: 다운로드용 파일
//    response.setContentType("image/png");  // inline 사용 시 타입 설정 필요

    response.setContentLength((int)file.length());  // 파일 크기

    String filename = URLEncoder.encode(orgname, "UTF-8");  // 인코딩

    // Content-disposition: 파일 처리방식을 지정하는 HTTP Header (inline/attachment)
    response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");  // attachment: 바로 다운로드
//    response.setHeader("Content-Disposition", "inline;filename=\"" + filename + "\"");  // inline: 브라우저로 보여줌

    try(OutputStream os = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os)) {

      Files.copy(Paths.get(file.getPath()), bos);
    }
  }
}
