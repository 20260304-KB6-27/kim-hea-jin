package org.scoula.member.mapper;

import java.util.List;
import org.scoula.member.domain.MemberVO;

public interface MemberMapper {
  // 1. 전체 회원 목록 조회
  List<MemberVO> getList();

  // 2. 단일 회원 상세 조회
  MemberVO read(Long no);

  // 3. 회원 등록 (데이터 삽입)
  int insert(MemberVO member);

  // 4. 회원 정보 수정
  int update(MemberVO member);

  // 5. 회원 삭제
  int delete(Long no);
}