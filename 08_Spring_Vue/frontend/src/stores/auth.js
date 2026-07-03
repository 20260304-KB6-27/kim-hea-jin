import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios'; // 인터셉터 설정 안 한 axios

// 초기 템플릿
const initState = {
  token: '',
  user: {
    username: '',
    email: '',
    roles: [],
  },
};

export const useAuthStore = defineStore('auth', () => {
  // 전역 상태값 (반응형)
  const state = ref({ ...initState });

  // computed 속성
  const isLogin = computed(() => !!state.value.user.username); // 로그인 여부
  const username = computed(() => state.value.user.username); // 사용자명
  const email = computed(() => state.value.user.email); // 이메일

  // 로그인 api 요청 -> localStorage에 저장
  const login = async (member) => {
    const { data } = await axios.post('/api/auth/login', member);

    // Pinia에 저장 -> 반응형
    state.value = { ...data };

    // localStorage에 저장
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  // 상태 복원
  const load = () => {
    const auth = localStorage.getItem('auth');

    if (auth != null) {
      state.value = JSON.parse(auth);
      console.log(`LocalStorage 내 토큰으로 상태 복원 완료!`);
    }
  };

  // 로그아웃
  const logout = () => {
    localStorage.clear(); // 로컬스토리지 토큰 지우기
    state.value = { ...initState }; // 상태 초기화
  };

  // 토큰 가져오기
  const getToken = () => state.value.token;

  // 스토어 초기화 시 상태 복원
  load();

  return {
    state,
    isLogin,
    username,
    email,
    login,
    logout,
    getToken,
  };
});
