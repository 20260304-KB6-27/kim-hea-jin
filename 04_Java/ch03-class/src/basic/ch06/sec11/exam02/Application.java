package basic.ch06.sec11.exam02;

public class Application {
    public static void main(String[] args) {

        // static 변수/메소드: instance 만들지 않아도 접근 가능
//        System.out.println(Earth.earthRadius);
//        System.out.println(Earth.getEarthRadius());

        // static final 사용예시
        System.out.println(Earth.EARTH_RADIUS);
        System.out.println(Earth.EARTH_SURFACE_AREA);

        // field(일반변수)는 instance 생성 후 접근 가능
        Earth earth = new Earth();
        System.out.println(earth.mainSatellite);

    }
}
