import { useAuthStore } from '@/stores/auth';

export const isAuthenticated = (to, from) => {
  const auth = useAuthStore();

  // 로그인 상태인지 확인 (로그인X 경우)
  if (!auth.isLogin) {
    console.log(`로그인 필요`);

    // 로그인 페이지로 redirect -> 원래 접근하려던 페이지를 담아서 제공
    // 로그인 후 원래 접근하려던 페이지로 자동 이동
    return { name: 'login', query: { next: to.name } };
  }

  console.log(`로그인 됨`);
};
