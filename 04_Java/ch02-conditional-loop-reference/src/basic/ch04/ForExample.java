package basic.ch04;

public class ForExample {
    public static void main(String[] args) {

        // for(초기값; 조건식; 증감식;){}
        for(int i=1; i <= 9; i++) {

            // 짝수가 아닐 때
            if (i % 2 != 0) {

                // 뒤의 코드 건너뛰고 증감식으로 이동
                continue;

                // for loop 종료
                // break;
            }
            System.out.println(i);  // 2 4 6 8
        }
    }
}
