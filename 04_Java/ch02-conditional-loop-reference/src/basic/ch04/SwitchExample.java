package basic.ch04;

public class SwitchExample {
    public static void main(String[] args) {

        // switch-case
        // 특정 case별로 코드 분기하고 싶을 떄 사용

        char grade = 'A';
        // char ''
        // String ""

//        switch (grade) {
//            case 'A':
//            case 'a':
//                System.out.println("A or a");
//                break;
//            case 'B':
//                System.out.println("B");
//                break;
//            default:
//                System.out.println("default");
//        }

        // 개선된 switch
        // 화살표 문법, break 미사용
        // 반환가능
        switch (grade) {
            case 'A', 'a' -> System.out.println("A or a");
            case 'B' -> System.out.println("B");
            default -> System.out.println("default");
        }

        String result = switch (grade) {
            case 'A', 'a' -> {
                System.out.println("A or a");
                yield "A or a";  // 반환값 지정
            }
            case 'B' -> "B";
            default -> "default";
        };
        System.out.println(result);
    }
}
