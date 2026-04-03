import {
  createRouter,
  createWebHistory,
  createWebHashHistory,
} from 'vue-router';
import Home from '@/pages/Home.vue';

/* 
네비게이션 가드 (beforeEnter)
 - false 반환 시 접근 차단
*/
const memmersIdGuard = (to, from) => {
  // /members인 경우 /members/:id 에서만 members/:id (MemberInfo)로 접근가능
  if (from.name !== 'members' && from.name !== 'members/id') {
    return false;
  }
};

const router = createRouter({
  // 지정되지 않은 경로에 대한 route 처리 불가
  // 전체 경로를 서버에 요청, 경로 파일 불러옴 (없을 경우 404 error)
  history: createWebHistory(import.meta.env.BASE_URL),

  // createWebHashHistory
  // # 이전 url의 html 불러옴
  // # 이후 url 저장X, browser에서 처리
  // history: createWebHashHistory(import.meta.env.BASE_URL),

  routes: [
    {
      path: '/',
      // 2번째 줄에 import한 객체 Home
      component: Home,
    },
    {
      path: '/members',
      name: 'members',
      // 지연로딩: 해당 경로에 처음 접근 시 컴포넌트 불러옴 (처음에 importX)
      // 초기로딩 속도 개선
      component: () => import('@/pages/MemberList.vue'),
    },
    {
      // path 대신 name으로 호출가능
      path: '/members/:id',
      name: 'members/id',
      component: () => import('@/pages/MemberInfo.vue'),
      // 접근 시 이동하기 전에 실행, false return 시 이동X
      // members에서만 접근해야 상세정보 볼 수 있게 설정
      beforeEnter: memmersIdGuard,
    },
    {
      /* 
      중첩 라우팅
       - 부모 컴포넌트 안에 <RouterView>를 두고 children 배열로 자식 라우트 정의
       - 자식 컴포넌트는 부모의 <RouterView> 위치에 랜더링
      */
      path: '/members-nested',
      component: () => import('@/pages/nested/membersLayout.vue'),
      children: [
        {
          // 기본값 /members-nested
          path: '',
          name: 'members-nested',
          component: () => import('@/pages/nested/MemberDefault.vue'),
        },
        {
          // /members-nested/:id
          // 동적 parameter id 설정
          path: ':id',
          name: 'members-nested/detail',
          component: () => import('@/pages/nested/MemberDetail.vue'),
        },
      ],
    },
  ],
});

export default router;
