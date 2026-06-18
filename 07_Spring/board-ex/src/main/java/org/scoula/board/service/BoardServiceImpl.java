package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor  // final, @notNull 필드만 포함하는 생성자 생성
public class BoardServiceImpl implements BoardService{

  private final BoardMapper boardMapper;

  @Override
  public List<BoardDTO> getList() {

    List<BoardVO> voList = boardMapper.getList();

    List<BoardDTO> dtoList = voList.stream()
            .map(BoardDTO::of)
            .toList();

    return dtoList;
  }

  @Override
  public BoardDTO get(Long no) {

    BoardVO vo = boardMapper.get(no);  // mybatis에서 객체 꺼냄

    BoardDTO dto = BoardDTO.of(vo);  // VO -> DTO

    // dto가 null 이면 예외처리
    return Optional.ofNullable(dto)
            .orElseThrow(() -> new NoSuchElementException());
  }

  @Override
  public void create(BoardDTO board) {
    // UserDetail 정보를 가져와서 Board에 같이 외래키로 작성

    // 전달받은 BoardDTO를 -> BoardVO로 변환
    BoardVO boardVO = board.toVO();

    boardMapper.create(boardVO);

  }

  @Override
  public int update(BoardDTO board) {
    // 작성자만 작성한 게시글 수정 가능

    int result = boardMapper.update(board.toVO());  // 영향을 미친 행의 개수 출력

    return result;
  }

  @Override
  public int delete(Long no) {

    int result = boardMapper.delete(no);

    return result;
  }
}
