package org.scoula.service;

import org.scoula.domain.BoardVO;
import org.scoula.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // ComponentScan에 추가 (컴포넌트로 등록)
public class BoardService {

  private BoardMapper mapper;

  @Autowired  // DI
  public BoardService(BoardMapper mapper) {
    this.mapper = mapper;
  }


  public List<BoardVO> getAllBoardByMapper() {

    // 전처리

    List<BoardVO> boardVOS = mapper.selectAllByMapper();

    return boardVOS;
  }

  public List<BoardVO> getAllByAnnotation() {

    // 전처리

    List<BoardVO> boardVOS = mapper.selectAllByAnnotaion();

    return boardVOS;
  }
}
