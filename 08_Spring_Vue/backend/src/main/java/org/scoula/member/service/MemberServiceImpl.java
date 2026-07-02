package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

  final MemberMapper mapper;
  final PasswordEncoder passwordEncoder;

  // 중복 체크
  @Override
  public Boolean checkDuplicate(String username) {
    MemberVO memberVO = mapper.findByUsername(username);
    return memberVO != null ? true: false;
  }

  @Transactional  // 하나의 단위로 처리
  @Override
  public MemberDTO join(MemberJoinDTO dto) {

    // dto -> vo 변환
    MemberVO member = dto.toVO();

    // 1. 비밀번호 암호화
    member.setPassword(passwordEncoder.encode(member.getPassword()));

    // 2. 회원정보 저장
    mapper.insert(member);

    // 3. 권한정보 저장
    AuthVO auth = new AuthVO();
    auth.setUsername(member.getUsername());
    auth.setAuth("ROLE_MEMBER");  // 기본권한 설정
    mapper.insertAuth(auth);

    // 4. 아바타 파일 저장
    saveAvatar(dto.getAvatar(), member.getUsername());

    return get(member.getUsername());
  }

  // 단건(상세)조회
  private MemberDTO get(String username) {
    MemberVO memberVO = Optional.ofNullable(mapper.get(username))
            .orElseThrow(NoSuchElementException::new);

    return MemberDTO.of(memberVO);
  }

  // 아바타 파일 저장 메소드
  private void saveAvatar(MultipartFile avatar, String username) {
    if(avatar != null && !avatar.isEmpty()) {
      File dest = new File("c:/upload/avatar", username + ".png");
      try {
        avatar.transferTo(dest);  // 파일 저장
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
