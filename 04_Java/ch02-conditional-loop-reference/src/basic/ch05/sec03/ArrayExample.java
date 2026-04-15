package basic.ch05.sec03;

public class ArrayExample {
    public static void main(String[] args) {
        // Array(배열)
        // 같은 타입의 데이터 여러개를 한 번에 관리할 때 사용

        int[] arr1; // 배열 변수 arr1 선언
        arr1 = new int[] {1, 2, 3}; // arr1 초기화 (new int[] 생략 불가)

        int[] arr2 = {1, 2, 3};  // 선언과 동시에 초기화 (new int[] 생략 가능)

        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
    }
}
