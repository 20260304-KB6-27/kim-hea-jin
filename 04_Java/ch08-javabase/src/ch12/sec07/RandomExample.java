package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
  public static void main(String[] args) {

    int[] selectNum = new int[6];
    Random random = new Random(3);
    System.out.print("선택번호: ");
    for (int i = 0; i < 6; i++) {
      selectNum[i] = random.nextInt(45) + 1;
      System.out.print(selectNum[i] + " ");
    }
    System.out.println();

    int[] goalNum = new int[6];
    random = new Random(5);
    System.out.print("당첨번호: ");
    for (int i = 0; i < 6; i++){
      goalNum[i] = random.nextInt(45) + 1;
      System.out.print(goalNum[i] + " ");
    }
    System.out.println();

    Arrays.sort(selectNum);
    Arrays.sort(goalNum);

    boolean result = Arrays.equals(selectNum, goalNum);
    System.out.print("당첨여부: ");
    if (result) {
      System.out.println("1등에 당첨되셨습니다.");
    } else {
      System.out.println("당첨되지 않았습니다.");
    }
  }
}
