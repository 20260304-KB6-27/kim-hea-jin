package basic.ch06.sec00.book;

public class Book {

    // field = 멤버변수 = 전역변수 = 인스턴스변수
    String author;
    String title;
    String coverType;
    int pageCount;

    // constructor (생성자)
    // constructor 없는 경우: 컴파일러가 기본 생성자 만듦
    // 기본 생성자: 매개변수 0개
    public Book() {
        System.out.println("기본 생성자 호출");
    }

    // alt + insert -> constructor -> field 선택 (다중선택: shift + 방향키)
    // 매개변수를 통해 받아온 값으로 field 초기화
    // 매개변수명 == field명 일 때 this로 구분 (this.field = 매개변수)
    // 생성자 오버로딩
    public Book(String author, String title, String coverType, int pageCount) {
        this.author = author;
        this.title = title;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    public Book(String author, String title) {
        // this(): 생성자 최상단에 위치
        this(author, title, "softcover", 12);
//        this.author = author;
//        this.title = title;
//        this.coverType = "soft cover";  // 미리 초기화 가능
//        this.pageCount = 10;
    }

    // method
    // 접근제어자 반환타입 메서드명(매개변수) {
    //     return 반환값
    // }

    // void: 반환값 없음
    public void introduce() {
        System.out.println(title + " 책의 작가는 " + author + "입니다.");
    }

    // alt + insert -> override -> toString()
    @Override
    public String toString() {
        return title + " 책의 작가는 " + author + "입니다.";
    }
}
