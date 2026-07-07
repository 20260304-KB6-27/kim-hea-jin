import { isAuthenticated } from '@/utils/guard.js';

export default [
  {
    path: '/board/list',
    name: 'board/list',
    component: () => import('../pages/board/BoardListPage.vue'),
  },
  {
    path: '/board/detail/:no',
    name: 'board/detail',
    component: () => import('../pages/board/BoardDetailPage.vue'),
  },
  {
    path: '/board/create',
    name: 'board/create',
    component: () => import('../pages/board/BoardCreatePage.vue'),
    // component 이동전에 isAuthenticated 동작 -> 로그인 확인
    beforeEnter: isAuthenticated, // 라우터로 이동 전 동작할 함수 지정
  },
  {
    path: '/board/update/:no',
    name: 'board/update',
    component: () => import('../pages/board/BoardUpdatePage.vue'),
    beforeEnter: isAuthenticated, // 라우터로 이동 전 동작할 함수 지정
  },
];
