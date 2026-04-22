package lecture.exam01;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        // 상황2. 사용자 입력값 만큼의 크기로 배열 생성 후
        //       사용자 입력값 인덱스의 배열요소 출력 프로그램

        int inputSize = 5;  // 사용자 입력값
        // inputSize < 0 -> NegativeArraySizeException
        int[] arr = new int[inputSize];  // 배열 크기 지정 필수, 자동초기화 값: 0
        System.out.println("배열 내의 요소들: " + Arrays.toString(arr));

        int inputIndex = 2; // 사용자 입력값
        // inputIndex >= inputSize 또는 inputIndex < 0 -> ArrayIndexOutOfBoundsException 발생
        System.out.println("사용자 입력 인덱스의 요소: " + arr[inputIndex]);

        System.out.println("프로그램 종료");
    }
}
