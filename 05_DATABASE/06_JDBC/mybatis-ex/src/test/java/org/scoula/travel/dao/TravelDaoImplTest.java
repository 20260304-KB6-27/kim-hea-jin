package org.scoula.travel.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TravelDaoImplTest {

  TravelDao dao = new TravelDaoImpl();

  @Test
  void getTotalCount() {
    int count = dao.getTotalCount();
    System.out.println("총 개수: " + count);
    Assertions.assertTrue(count > 0);
  }

  @Test
  void getDistricts() {
    List<String> list = dao.getDistricts();
    list.forEach(System.out::println);
    Assertions.assertTrue(list.size() > 0);
  }

  @Test
  void getTravelsByDistrict() {
    List<TravelVO> list = dao.getTravelsByDistrict("강원권");
    list.forEach(System.out::println);
  }

  @Test
  void insert() {
    TravelVO vo = TravelVO.builder()
            .district("강원권")
            .title("두물머리")
            .description("경치좋음")
            .address("양평")
            .phone("111-222-3333")
            .build();

    dao.insert(vo);
    System.out.println(vo);
  }

  @Test
  void update() {
    TravelVO vo = TravelVO.builder()
            .no(114L)
            .district("강원권1")
            .title("두물머리1")
            .description("경치좋음1")
            .address("양평1")
            .phone("111-222-33331")
            .build();

    dao.update(vo);
    System.out.println(vo);
  }

  @Test
  void remove() {
    dao.remove(114L);

  }

  @Test
  void getTravels() {
    List<TravelVO> list = dao.getTravels(1, 10);
    list.forEach(System.out::println);
    Assertions.assertTrue(list.size() > 0);
  }

  @Test
  void getTravel() {
    Optional<TravelVO> vo = dao.getTravel(1L);
    System.out.println(vo);
  }
}