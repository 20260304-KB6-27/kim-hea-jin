package org.scoula.travel.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelVO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelDaoImplTest {

  private TravelDao dao;

  @BeforeEach
  void setUp() {
    dao = new TravelDaoImpl();
  }

  @Test
  void getTravels() {

    List<TravelVO> travels = dao.getTravels();

    System.out.println(travels);

    assertNotNull(travels);
    assertFalse(travels.isEmpty(), "여행지 목록이 비면 안 됨.");
  }

  // 지역별 여행지 조회
  @Test
  void getTravelsByDistrict() {
    String district = dao.getDistricts().get(0);
    List<TravelVO> travels = dao.getTravels(district);
    assertNotNull(travels);
    travels.forEach(t -> assertEquals(district, t.getDistrict()));
  }
}