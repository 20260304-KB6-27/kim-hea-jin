package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

  // mapping
  // 긴 SQL문
  List<BoardVO> selectAllByMapper();

  // annotation
  // 짧은 SQL문
  @Select("""
  select * from tbl_board_ex
  """)
  List<BoardVO> selectAllByAnnotaion();
}
