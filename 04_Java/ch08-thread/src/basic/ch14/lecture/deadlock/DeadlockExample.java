package basic.ch14.lecture.deadlock;

public class DeadlockExample {

  // Deadlock
  //: 두개 이상의 스레드가 서로 가진 lock을 기다리면서 무한정 대기하는 상태
  // deadlock 발생 조건
  // - 상호 배제 -> 한 번에 하나의 공유자원만 사용 가능
  // - 점유 대기 -> 하나를 가지고 다른 공유자원을 기다림
  // - 비선점 -> 강제로 다른 스레드가 점유한 공유자원을 뺏을 수 없음
  // - 순환 대기 -> 서로 물려있는 상태
  // deadlock 해제 방법
  // -> lock 획득 순서 통일 (t1, t2 둘 다 티셔츠 -> 바지 순으로 접근)

  // 공유자원
  static final Object 티셔츠 = new Object();
  static final Object 바지 = new Object();

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (티셔츠) {
          System.out.println("형: 티셔츠를 입었다. 바지를 입자");

          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("형: 바지 찾으러 가는 중");

          synchronized (바지) {
            System.out.println("형: 옷 다 입었다.");
          }
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (바지) {
          System.out.println("동생: 바지를 입었다. 티셔츠를 입자");

          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("동생: 티셔츠 찾으러 가는 중");

          synchronized (티셔츠) {
            System.out.println("동생: 옷 다 입었다.");
          }
        }
      }
    });

    t1.start();
    t2.start();
  }
}
