package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Optional;

/*
DAO (Data Acess Object)
- DB 접근 담당 객체
- VO 사용해 DB의 CURD할 때 사용
 */

/*
Interface - 구현체 형태로 구현하는 이유
- 결합도를 낮추기 위함
- 유지보수성 향상
- 확장성 향상
- 테스트 용이성 (Mock(가짜) 단위 테스트 진행가능)
 */

public interface TravelDao {
    void insert(TravelVO travel);
    void insertImage(TravelImageVO image);

    int getTotalCount();

    List<String> getDistricts();

    List<TravelVO> getTravels();

    List<TravelVO> getTravels(int page);

    List<TravelVO> getTravels(String district);

    Optional<TravelVO> getTravel(Long no);
}