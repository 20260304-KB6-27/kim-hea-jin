import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // views 폴더 안의 vue 경로 지정
  // 경로 요청 시 routes 배열 순서대로 해당 주소 찾고 .vue 보여줌
  routes: [
    // 기본 경로 ('/') 꼭 있어야 함
    { path: '/', component: () => import('@/views/Home.vue') },
    { path: '/about', component: () => import('@/views/About.vue') },
    { path: '/todos', component: () => import('@/views/TodoList.vue') },
    { path: '/todos/add', component: () => import('@/views/AddTodo.vue') },
    {
      path: '/todos/edit/:id',
      component: () => import('@/views/EditTodo.vue'),
    },
    {
      path: '/students',
      component: () => import('@/views/Students.vue'),
    },

    // :paths 동적 파라미터
    // (.*)*/ : 하위의 모든 문자열을 포함하는 정규식
    { path: '/:paths(.*)*', component: () => import('@/views/NotFound.vue') },
  ],
});

export default router;
