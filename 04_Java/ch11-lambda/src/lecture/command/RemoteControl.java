package lecture.command;

// Invoker: Command 모아서 실행요청 전달 객체
public class RemoteControl {

  private Command command;

  // setter
  public void setCommand(Command command) {
    this.command = command;
  }

  // command 실행 함수
  // command에 따라 다른 결과
  public void pressButton() {
    command.execute();
  }
}
