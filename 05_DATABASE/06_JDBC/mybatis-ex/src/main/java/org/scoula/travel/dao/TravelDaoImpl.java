package org.scoula.travel.dao;

import org.apache.ibatis.session.SqlSession;
import org.scoula.travel.database.MyBatisConfig;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/*
 SqlSession method
 - selectOne(mapper.xml의 namespace + id): 결과가 한 개만 나올 때
 - selectList(id): 결과가 0개 이상(list 형태) 나올 때
 - insert(id, param): return이 영향받은 행의 수
 - update(id, param): return이 영향받은 행의 수
 - delete(id, param): return이 영향받은 행의 수

 Transaction
 - commit(): 변경사항 DB에 반영
 - rollback(): 변경사항 취소(DB 변경X)
 */

public class TravelDaoImpl implements TravelDao{

  // 중요: namespace 지정해 가져옴
  static final String NAMESPACE = "org.scoula.travel.dao.TravelDao.";

  // 전체 개수 조회
  @Override
  public int getTotalCount() {
    return MyBatisConfig.getSqlSession()
            // 중요: Sql문 호출 시 경로 + 메서드 일치시켜야 함
            .selectOne(NAMESPACE + "getTotalCount");
  }

  // 페이지 별 조회
  @Override
  public List<TravelVO> getTravels(int page, int size) {
    int start = (page - 1) * size;
    Map map = Map.of("start", start, "size", size);
    return MyBatisConfig.getSqlSession()
            .selectList(NAMESPACE + "getTravels", map);
  }

  // 지역 목록 조회
  @Override
  public List<String> getDistricts() {
    return MyBatisConfig.getSqlSession()
            .selectList(NAMESPACE + "getDistricts");
  }

  // 특정 지역의 여행지 목록 조회
  @Override
  public List<TravelVO> getTravelsByDistrict(String district) {
    return MyBatisConfig.getSqlSession()
            // mapper.xml에 매개변수(district) 넘겨줌
            .selectList(NAMESPACE + "getTravelsByDistrict", district);
  }

  // 특정 여행지 상세 조회
  @Override
  public Optional<TravelVO> getTravel(Long no) {
    TravelVO travelVO = MyBatisConfig.getSqlSession()
            .selectOne(NAMESPACE + "getTravel", no);
    return Optional.ofNullable(travelVO);
  }

  /*
  트랜잭션 처리 메서드
  */
  private void transaction(Consumer<SqlSession> action) {
    try (SqlSession session = MyBatisConfig.getSqlSession()) {
      action.accept(session);
      session.commit();  // DB에 반영
    }
  }

  // 삽입
  @Override
  public void insert(TravelVO travel) {

    // mapper.xml에 매개변수(travel) 넘겨줌
    transaction(session -> session.insert(NAMESPACE + "insert", travel));
  }

  // 수정
  @Override
  public void update(TravelVO travel) {
    transaction(session -> session.update(NAMESPACE + "update", travel));
  }

  // 삭제
  @Override
  public void remove(Long no) {
    // delete: travel-mapper.xml의 삭제 태그명
    transaction(session -> session.delete(NAMESPACE + "remove", no));
  }
}
