package lecture.exam02;

public class Application3 {

    public static void main(String[] args) {

        // 상황.
        // 사용자입력문자열 => 숫자로 치환 => 배열 생성 => 특정 인덱스 출력

        String inputSize = "10";
        int inputIndex = 5;
//        try {
//            int size = Integer.parseInt(inputSize);  // NumberFormatEx
//            int[] arr = new int[size]; // NegativeArraySizeEx
//            System.out.println(arr[inputIndex]);  // ArrayIndexOutOfBoundEx
//        } catch (NumberFormatException e){
//            System.out.println("치환 불가");
//        } catch (NegativeArraySizeException e) {
//            System.out.println("배열 크기는 음수가 될 수 없습니다.");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("맞지않는 index");
//        } finally {
//            System.out.println("프로그램 종료");
//        }
        // 다중 catch 블럭 작성 가능 => 각 상황별 예외처리 구문 써두기

//        try {
//            int size = Integer.parseInt(inputSize);  // NumberFormatEx
//            int[] arr = new int[size]; // NegativeArraySizeEx
//            System.out.println(arr[inputIndex]);  // ArrayIndexOutOfBoundEx
//        } catch (NumberFormatException | NegativeArraySizeException e){
//            System.out.println("치환 불가 또는 배열 크기 음수 불가");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("array에 벗어나는 index");
//        }
        // 여러 예외클래스를 묶어서 동일 로직을 처리할 경우 -> | (파이프 기호)로 연결

        try {
            int size = Integer.parseInt(inputSize);  // NumberFormatEx
            int[] arr = new int[size]; // NegativeArraySizeEx
            System.out.println(arr[inputIndex]);  // ArrayIndexOutOfBoundEx
        } catch (ArrayIndexOutOfBoundsException e) {  // 자식 예외클래스 (부모보다 위에 위치해야 함)
            System.out.println("array 벗어나는 index");
        } catch (RuntimeException e){  // 매개변수 다형성 (자식 클래스 대입 가능 - upcasting)
            System.out.println("치환 불가 또는 배열 크기 음수 불가");
        }
        // 처리할 예외클래스가 많은 경우 -> 대신 부모 예외클래스를 매개변수로 사용
        // 부모 예외클래스는 자식 예외클래스보다 뒤에 위치해야 함 (순서 중요)
    }


    /*
        Unchecked Exception (실행 예외)
        1. 컴파일 에러가 뜨지 않음
        2. 예외 처리 코드가 필수가 아님
            => 즉, 예외 처리 코드를 필수로 작성하지 않아도 프로그램 동작 가능
        3. 예측 가능한 상황 => 조건문으로도 핸들링 가능
        4. RuntimeException 계층
     */

}
