import { useAuthStore } from '@/stores/auth';
import axios from 'axios';
import { useRouter } from 'vue-router';

const instance = axios.create({
  timeout: 1000, // 요청 타임아웃
});

// 공통 응답 처리
instance.interceptors.response.use(
  (response) => {
    if (response.status == 200) {
      console.log('🍥응답 정상: ', response.config.url);
      return response;
    }
    if (response.status == 404) {
      return Promise.reject('✈️페이지 없음 : ' + response.config.url);
    }
    return response;
  },
  async (error) => {
    if (error.response?.status === 401) {
      console.log('인증 실패 (401) - 토큰 유효하지 않음');
      const {logout} = useAuthStore();
      logout();  // 기존 토큰 삭제 
      router.push("/auth/login");  // 로그인 페이지로 이동 
    }
    if (error.response?.status === 403) {
      console.log('접근 권한 없음 (403) - 인증은 되었으나 권한 부족');
    }

    console.log('API 요청 실패:', error.response?.status, error.message);
    return Promise.reject(error);
  },
);

// 공통 요청 처리 - 모든 요청에 JWT 토큰 자동으로 추가하기
instance.interceptors.request.use(
  (config) => {

    // 방법 1. AuthStore에서 JWT 추출
    const {getToken} = useAuthStore();
    const token = getToken();

    // 방법 2. LocalStorage에서 JWT 추출
    // const token = JSON.parse(localStorage.getItem('auth'))?.token;
    // console.log(`인터셉터에서 header에 담을 토큰 : ${token}`);

    // Authorization 헤더에 담기 -> Bearer 붙여서 요청에 담기
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    } else {
      console.log(`JWT가 없습니다.`);
    }
    return config;
  },
  (error) => {
    // 요청 중 에러 발생 처리
    return Promise.reject(error);
  },
);
export default instance;
