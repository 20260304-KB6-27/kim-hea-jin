package ch11.sec06;

public class Account {
  private long balance;

  public Account() { }

  public long getBalance() {
    return balance;
  }

  public void deposit(int money) {
    balance += money;
    System.out.println(money + "원 입금, 현재 잔액: " + balance);
  }

  public void withdraw(int money) throws InsufficientException{
    if (balance < money) {
      throw new InsufficientException("잔고 부족: " + (money-balance) + "모자람");
    }
    balance -= money;
    System.out.println(money + "원 출금, 현재 잔액: " + balance);
  }
}
