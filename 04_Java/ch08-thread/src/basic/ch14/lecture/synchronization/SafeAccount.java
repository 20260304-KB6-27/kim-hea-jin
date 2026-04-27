package basic.ch14.lecture.synchronization;

public class SafeAccount {
  // 공유 자원 -> 여러 스레드가 사용 가능
  private int balance = 1000; // 계좌 잔액

  // 출금 메서드 - 동기화된 버전
  // synchronized
  // : 특정 코드 영역 (임계영역)에 >>한 번에 하나의 스레드<<만 들어올 수 있도록 막아주는 키워드
  public synchronized void withdraw(int money) {
    if(balance >= money) {
      try {
        Thread.sleep(1000); // 다른 스레드의 개입 가능성을 높이기 위한 지연
      } catch(InterruptedException e) {}
      balance -= money;
      System.out.println("출금 후 잔액: " + this.balance);
    }
  }

  public int getBalance() {
    return balance;
  }
}
