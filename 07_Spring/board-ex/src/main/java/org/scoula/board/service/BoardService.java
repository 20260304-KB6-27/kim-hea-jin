package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

  // 게시글 전체 조회
  public List<BoardDTO> getList();

  // 게시글 단건 조회
  public BoardDTO get(Long no);

  // 게시글 생성
  public void create(BoardDTO board);

  // 게시글 수정
  public int update(BoardDTO board);

  // 게시글 삭제
  public int delete(Long no);
}
