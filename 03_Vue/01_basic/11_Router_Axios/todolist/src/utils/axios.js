import axios from 'axios';

const instance = axios.create({
  baseURL: 'api/',

  // axios 요청에 대해 공통된 설정들 저장, 꺼내 쓸 수 있음
  // header
  //   headers: {
  //     // 공통 헤더들 설정
  //     Authorization: "abcd"
  //   },
  //
  //   timeout
});

export default instance;
