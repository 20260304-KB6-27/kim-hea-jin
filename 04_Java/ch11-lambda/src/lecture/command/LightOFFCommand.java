package lecture.command;

// Concrete Command
public class LightOFFCommand implements Command{

  private final Light light;

  public LightOFFCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }
}
