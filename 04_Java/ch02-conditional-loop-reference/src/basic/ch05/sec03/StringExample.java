package basic.ch05.sec03;

public class StringExample {
    public static void main(String[] args) {

        // String 객체 타입
        String str1 = "hello";

        // 특징) 불변 객체
        // 객체 변수에 새로운 값 대입 시 기존값이 변경되지 않고 새로운 객체 생성됨
        String str2 = "hello";

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));  // 동일값 출력

        String str3 = new String("hello");  // 새로운 객체 생성 및 초기화 (str1, str2와 주소값 다름)
        System.out.println(System.identityHashCode(str3));

        // str1, str2 주소값 비교
        System.out.println(str1 == str2);   // true
        // 값 자체만 비교
        System.out.println(str1.equals(str2));  // true

        // str1, str3 주소값 비교
        System.out.println(str1 == str3);   // false
        // 값 자체만 비교
        System.out.println(str1.equals(str3));  // true

        str1 = str1 + "world";  // 새 주소값을 갖고 heap의 "helloworld"를 가리키는 새로운 객체 str1 생성됨

        // System.identityHashCode(): 코드에서 주소값과 비슷한 값 보는 메소드 (주소값은 아님)
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}
