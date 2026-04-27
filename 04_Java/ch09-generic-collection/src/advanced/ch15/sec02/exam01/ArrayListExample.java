package advanced.ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListExample {

  // ArrayList, LinkedList 둘다 List 구현체
  public static void main(String[] args) {

    // ArrayList
    // 메모리에 데이터가 연속적으로 저장
    // 크기가 자동으로 늘어나는 동적 배열
    // List<Board> list = new ArrayList<>();

    // LinkedList
    // 데이터를 노드 단위로 저장, (데아터 + 다음 노드 주소)를 가지고 연결
    // 연속된 메모리가 아님
    List<Board> list = new LinkedList<>();

    // 객체 추가
    list.add(new Board("제목1", "내용1", "글쓴이1"));
    list.add(new Board("제목2", "내용2", "글쓴이2"));
    list.add(new Board("제목3", "내용3", "글쓴이3"));
    list.add(new Board("제목4", "내용4", "글쓴이4"));

    // 저장된 총 객체 수 (list 크기)
    System.out.println("list.size() = " + list.size());

    // 객체 꺼내기
    Board board = list.get(0);   // 0번째 인덱스 객체
    System.out.println("board = " + board);

    // 객체 삭제하기
    list.remove(1);
    list.remove(board);

    System.out.println("-----------------삭제 후------------------");
    // list 전체 출력
    for (Board b : list) {
      System.out.println(b);
    }
  }
}
