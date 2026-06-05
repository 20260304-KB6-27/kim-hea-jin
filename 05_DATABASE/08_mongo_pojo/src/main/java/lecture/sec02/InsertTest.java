package lecture.sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class InsertTest {
//  public static void main(String[] args) {
//
//    // MongoCollection: 컬렉션에 접근하기 위한 객체 -> 쿼리문 사용가능
//    MongoCollection<Document> collection = Database.getCollection("todo");
//
//    Document document = new Document();
//    document.append("title", "MongoDB");
//    document.append("desc", "MongoDB 자바연결");
//    document.append("done", false);
//
//    // 쿼리가 처리된 결과 반환. 생성된 ID값 조회 가능
//    InsertOneResult result = collection.insertOne(document);
//
//    System.out.println("==> insertResult : " + result.getInsertedId());
//
//    collection.insertOne(document);
//
//    Database.close();
//  }
}
