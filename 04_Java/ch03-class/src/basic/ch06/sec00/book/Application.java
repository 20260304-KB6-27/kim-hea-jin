package basic.ch06.sec00.book;

public class Application {
    public static void main(String[] args) {

        // 객체 생성
        // new Book(): 생성자 호출
        Book myBook = new Book();  // heap에 공간 확보
        myBook.title = "해리포터와 마법사의 돌";
        myBook.author = "조앤 k 롤링";
        myBook.coverType = "하드커버";
        myBook.pageCount = 320;

        System.out.println(myBook.title);

        Book myBook2 = new Book("조앤 k 롤링", "해리포터와 혼혈왕자", "하드커버", 320);

        myBook2.introduce();

        System.out.println(myBook2);  // Object myBook2를 String으로 변환해 출력 (toString() 수행하는 것과 동일)
    }
}
