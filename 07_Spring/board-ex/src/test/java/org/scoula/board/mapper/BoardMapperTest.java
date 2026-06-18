package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {

  @Autowired
  private BoardMapper mapper;

  @Test
  void getList() {
    // 1. 서비스의 getList() 메서드 실행
    List<BoardVO> list = mapper.getList();

    // 2. 검증 (리스트가 null이 아닌지 확인)
    assertNotNull(list);

    // 3. 로그 출력 (조회된 개수 및 전체 목록 확인)
    log.info("조회된 게시글 개수: {}", list.size());
    for (BoardVO board : list) {
      log.info("게시글 정보: {}", board);
    }
  }

  @Test
  void create() {
    BoardVO board = BoardVO.builder()
            .title("새로운 게시글 제목").content("새로운 게시글 내용").writer("testUser").build();

    mapper.create(board);

    log.info(board);  // no 값 확인
  }

  @Test
  void update() {
    BoardVO board = BoardVO.builder()
            .no(7L)
            .title("변경된 게시글 제목").content("변경된 게시글 내용").writer("변경된 writer").build();

    int result = mapper.update(board);

    assertEquals(1, result);

  }

  @Test
  void delete() {
    Long targetNo = 8L;

    int result = mapper.delete(targetNo);

    assertEquals(1, result);

    log.info("삭제된 게시글 개수: {}", result);
  }
}