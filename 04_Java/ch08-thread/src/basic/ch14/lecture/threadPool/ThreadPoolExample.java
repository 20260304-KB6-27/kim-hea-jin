package basic.ch14.lecture.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
  public static void main(String[] args) {

    // 스레드 풀 생성 (스레드 5개)
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    for(int i = 0; i < 15; i++) {
      final int taskNum = i;
      // 스레드 풀에서 스레드 하나 꺼내서 작업 할당
      executorService.execute(() -> {
        System.out.println("작업 " + taskNum + " 실행 중... (Thread: "
                + Thread.currentThread().getName() + ")");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}
      });
    }

    // 스레드 풀 종료 (자원 반납)
    executorService.shutdown();
  }
}
