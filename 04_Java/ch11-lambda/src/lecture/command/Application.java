package lecture.command;

public class Application {

  // 커맨드 패턴 (Command)
  // 요청을 객체로 만들어서 실행, 취소, 재사용 가능하게 하는 패턴

  // Command: 실행 명령 (인터페이스)
  // ConcreteCommand: Command의 구현체
  // Receiver: 실제 동작 수행 객체
  // Invoker: Command 보관, 실행 객체
  // Client: 실행하는 곳

  public static void main(String[] args) {

    // command의 실제 동작 수행 객체(light)
    Light light = new Light("거실");

    // Command 구현체(LightOn/OffCommand) 생성해 Reciever(light) 주입
    Command lightOn = new LightOnCommand(light);
    Command lightOff = new LightOFFCommand(light);

    // Invoker: Command 실행기
    RemoteControl remote = new RemoteControl();

    // Command 등록
    remote.setCommand(lightOn);

    System.out.println("거실불 = " + light);
    // Command 실행
    remote.pressButton();
    System.out.println("거실불 = " + light);


    Light light2 = new Light("화장실");

    remote.setCommand(new LightOnCommand(light2));

    System.out.println("화장실 불 = " + light2);
    // Command 실행
    remote.pressButton();
    System.out.println("화장실 불 = " + light2);

    // 같은 remote 객체에 다른 Light 객체 주입 가능
    // => 결합도 낮춤 (RemoteControl Light 몰라도 됨)
    // 명령(메서드) 바꾸기 쉬움
    // 다른 객체들에서도 동일한 방식으로 제어 가능
  }
}
