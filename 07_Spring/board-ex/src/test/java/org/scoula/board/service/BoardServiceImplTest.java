package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceImplTest {

  @Autowired
  private BoardService boardService;

  // 성공 테스트
  @Test
  void get() {
    Long testNo = 1L;
    BoardDTO board = boardService.get(testNo);

    assertNotNull(board);  // 조회한 객체의 null 여부
    assertEquals(testNo, board.getNo());  // no 일치 여부

    log.info("조회한 게시글: {}", board);
  }

  // 실패 테스트
  @Test
  void get2() {
    Long testNo = 99L;

    NoSuchElementException e = assertThrows(NoSuchElementException.class,
          () -> {boardService.get(testNo);
    });

    log.info("예외메시지: {}", e.toString());
  }

  @Test
  void insert() {
    BoardDTO board = BoardDTO.builder()
            .title("새로운 게시글 제목").content("새로운 게시글 내용").writer("testUser").build();

//    boardService.create(board);
  }
}