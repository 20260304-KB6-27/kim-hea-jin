package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.utills.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final static String BASE_DIR = "c:/upload/board";  // 실제로 저장할 경로
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.getList().stream()
                .map(BoardDTO::of)
                .toList();
    }

    @Override
    public BoardDTO get(Long no) {
        BoardVO vo = boardMapper.get(no);

        BoardDTO dto = BoardDTO.of(vo);

        return Optional.ofNullable(dto)
                .orElseThrow(() -> new NoSuchElementException("🍀no: " + no + "번 게시글이 없습니다."));
    }

    @Transactional  // 2가지의 insert문 중 하나라도 예외 발생 시 rollback
    @Override
    public BoardDTO create(BoardDTO board) {

        BoardVO boardVo = board.toVo();

        boardMapper.create(boardVo);  // 게시글 생성(mybatis-insert)

        // if 첨부파일 존재 -> 저장 (DB 등록용, 실제 파일 등록용 두가지 필요
        List<MultipartFile> files = board.getFiles();

        if(files != null && !files.isEmpty()) {
            // 첨부파일이 있을 경우
            // 외래키(board.no), 첨부파일 필요
            upload(boardVo.getNo(), files);  // mybatis-insert
        }

        return get(boardVo.getNo());
    }

    // 파일 업로드
    private void upload(Long dno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;

            // 파일 직접 저장 -> IOException
            try {
                // 1. 실제 파일을 서버에 저장
                String uploadPath = UploadFiles.upload(BASE_DIR, part);

                // 2. 데이터베이스에 저장
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, dno, uploadPath);  // VO 객체 생성
                boardMapper.createAttachment(attach);  // mybatis mapping

            } catch (IOException e) {
                throw new RuntimeException();  // 예외 발생 시 @Transaction에서 감지해 Rollback
            }
        }
    }


    @Override
    public BoardDTO update(BoardDTO board) {

        int result = boardMapper.update(board.toVo());

        return get(board.getNo());  // 실제 서비스 만들 때는 수정 필요
    }

    @Override
    public BoardDTO delete(Long no) {

        int result = boardMapper.delete(no);

        return get(no);
    }

    @Override
    public BoardAttachmentVO getAttachment(Long no) {

        return boardMapper.getAttachment(no);
    }
}
