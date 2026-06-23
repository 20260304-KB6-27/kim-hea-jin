package org.scoula.board.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.docs.BoardControllerDocs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // @Responsebody(body 영역에 값 직접 작성) + @Controller
@RequestMapping("/api/board")
@RequiredArgsConstructor  // final / not null 조건 필드 생성자 만듦
public class BoardController implements BoardControllerDocs {

  private final BoardService service;

  // 전체조회
  @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
          @ApiResponse(code = 400, message = "잘못된 요청입니다."),
          @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
  })
  @GetMapping("/list")
  public List<BoardDTO> getList() {
    return service.getList();
  }

  // 응답 시 Header, HTTP Status 같이 조작할 때 사용
  // ResponseEntity: Header, Body의 내용 작성가능
  @GetMapping("")
  public ResponseEntity<List<BoardDTO>> getList2() {
    return ResponseEntity.ok(service.getList());
  }

  // 단건조회 api/board/{no}
  @GetMapping("/{no}")  // no 매개변수로 전달
  public ResponseEntity<BoardDTO> getById(@PathVariable Long no) {
    return ResponseEntity.ok(service.get(no));
  }

  // 생성 [POST] /api/board
  // 일반적으로 복수형(boards) 사용
  @PostMapping("")
  public ResponseEntity<BoardDTO> create(
          @ApiParam(value = "🍀 생성할 게시글 정보", required = true)
          @RequestBody BoardDTO boardDTO) {  // 요청(request) 시 BoardDTO 구분해 필요한 필드만 가져오는것 권장

    // 201: 새로운 데이터 입력
//    return ResponseEntity.ok(service.create(boardDTO));

      // URI 전달
//    return ResponseEntity
//            .created(URI.create("/board/" + boardDTO.getNo()))
//            .body(service.create(boardDTO));
//
    // Status 조작
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.create(boardDTO));
  }

  // 수정 [PUT] /api/board/{no}
  @PutMapping("/{no}")
  public ResponseEntity<BoardDTO> update(
          @PathVariable Long no, @RequestBody BoardDTO boardDTO) {

    boardDTO.setNo(no);

    return ResponseEntity.ok(service.update(boardDTO));
  }

  // 삭제 [DELETE] /api/board/{no}
  @DeleteMapping("/{no}")
  public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
    return ResponseEntity.ok(service.delete(no));
  }
}
