package basic.lecture;

public enum Grade {

    // 권한 인증인가 설정 시 (USER / ADMIN) 사용

    // 객체 형태로 쓰일 수 있음
    A(95, "최우수"),
    B(85, "우수");

    // final (상수) 생성 가능 -> 미리 만든 객체처럼 사용 가능
    // Rest API 사용시 쓰임
    private final int score;
    private final String description;

    Grade(int score, String description) {
        this.score = score;
        this.description = description;
    }
}
