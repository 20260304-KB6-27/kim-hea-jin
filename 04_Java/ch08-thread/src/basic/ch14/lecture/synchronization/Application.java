package basic.ch14.lecture.synchronization;

public class Application {
  public static void main(String[] args) {

    // Account account = new Account();
    SafeAccount account = new SafeAccount();  // 동기화 적용

    // 작업 스레드 정의
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        // 기다리는 1000ms동안 다른 작업 스레드 대기
       account.withdraw(300);

      }
    });

    // 작업 스레드 정의
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        account.withdraw(300);
      }
    });

    // 작업 스레드 동작 (synchronized -> 순서대로 동작)
    t1.start();
    t2.start();

    // main thread 동작
    System.out.println("main thread 동작");

  }
}
