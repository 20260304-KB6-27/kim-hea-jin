package lecture.command;

// Receiver
public class Light {

  private final String location;
  private boolean isOn = false;

  public Light(String location) {
    this.location = location;
  }

  public void on() {
    isOn = true;
    System.out.println(location + "전등 ON");
  }

  public void off() {
    isOn = false;
    System.out.println(location + "전등 OFF");
  }

  // 상태 확인용
  @Override
  public String toString() {
    return "Light{" +
            "location='" + location + '\'' +
            ", isOn=" + isOn +
            '}';
  }
}
