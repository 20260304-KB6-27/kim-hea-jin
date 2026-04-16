package basic.ch06.sec11.exam02;

public class Earth {

    String mainSatellite;

    // static
    // - 클래스 자체에 소속됨
    // - 모든 인스턴스들이 동일한 값을 유지해야할 때 사용
    // 인스턴스를 만들지 않아도 클래스명.정적멤버 형태로 참조 가능
    // 컴파일 시 메모리에 바로 로드됨

    // final: 상수 (수정불가)
    // 상수 명명법: 대문자_대문자
    static final int EARTH_RADIUS = 6400;   // 초기화 필수
    static final double EARTH_SURFACE_AREA;

//    public static int getEarthRadius() {
//        return earthRadius;
//    }

    // 정적 블록
    // 클래스가 메모리에 할당될 때 딱 한 번 실행됨
    // static 멤버를 초기화할 때 주로 사용 (사용빈도 낮음)
    static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }

    // 인스턴스 블록
    // 인스턴스 만들어질 때마다 초기화
    {
        mainSatellite = "스타링크";
    }
}
