package org.scoula.member.service;

import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;

public interface MemberService {

  // 회원 pk 중복검사
  Boolean checkDuplicate(String username);

  MemberDTO join(MemberJoinDTO member);
}
