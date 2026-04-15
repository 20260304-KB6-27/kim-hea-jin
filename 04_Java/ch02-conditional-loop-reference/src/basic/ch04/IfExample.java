package basic.ch04;

public class IfExample {
    public static void main(String[] args) {

        int score = 85;

        if(score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            // 중첩
            if(score>=85) {
                System.out.println("B+");
            } else {
                System.out.println("B");
            }
        } else {
            System.out.println("C");
        }
    }
}
