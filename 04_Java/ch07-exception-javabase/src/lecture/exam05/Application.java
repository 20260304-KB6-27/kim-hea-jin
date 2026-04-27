package lecture.exam05;

public class Application {
    public static void main(String[] args) {
        CheckSystem cs = new CheckSystem();

        cs.checkScore(50);
        cs.checkGrade('A');

        System.out.println("프로그램 종료");
    }
}
