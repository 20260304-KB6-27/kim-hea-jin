package basic.ch13.sec02.exam01;

public class TVAgency implements Rentable<TV>{

  @Override
  public TV rent() {

    System.out.println("TV 객체 생성");

    // TV class instance return
    return new TV();
  }
}
