package org.scoula.utills;

// 고유한 파일명을 만드는 메소드 생성용
public class UploadFileName {
  public static String getUniqueName(String filename) {

    // 점(확장자) 위치 인덱스 찾기(뒤에서부터)
    int ix = filename.lastIndexOf(".");

    String name = filename.substring(0, ix);  // 파일명 추출
    String ext = filename.substring(ix+1);  // 확장자명 추출

    return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
  }
}
