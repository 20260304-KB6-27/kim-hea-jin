package advanced.ch14.exam;

public class ThreadExample {
  public static void main(String[] args) {

    MovieThread movieThread = new MovieThread();
    MusicRunnable musicRunnable = new MusicRunnable();

    Thread thread1 = new Thread(movieThread);
    Thread thread2 = new Thread(musicRunnable);

    thread1.start();
    thread2.start();
  }
}
