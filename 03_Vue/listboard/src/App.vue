<template>
  <div>
    <h1>📌 게시판 목록 v3</h1>

    <!-- 새 게시글 작성 -->
    <PostInput @add="addPost"></PostInput>

    <!-- 목록 출력 -->
    <div>
      <!-- 자식 PostLIst에 sortedPosts 전달(prop) -->
      <PostList
        :sortedPosts="sortedPosts"
        :modifyid="modifyid"
        @modify="modifyPost"
        @save="saveModify"
        @cancel="cancelModify"
        @delete="deletePost"
      ></PostList>
    </div>
  </div>
</template>

<script setup>
import PostInput from './components/PostInput.vue';
import PostList from './components/PostList.vue';
import { ref, computed } from 'vue';

const modifyid = ref(null);
const tempTitle = ref('');
const tempContent = ref('');

let ts = new Date().getTime();

const posts = ref([
  {
    id: ts + 1,
    no: 1,
    title: 'Vue.js 기초 배우기',
    content:
      'Vue.js는 사용자 인터페이스를 구축하기 위한 프로그레시브 프레임워크입니다.',
  },
  {
    id: ts + 2,
    no: 2,
    title: '자바스크립트 ES6 문법',
    content:
      'ES6는 JavaScript의 최신 문법을 포함하며, let/const, 화살표 함수, 구조 분해 할당 등을 제공합니다.',
  },
  {
    id: ts + 3,
    no: 3,
    title: 'Node.js와 Express',
    content:
      'Node.js는 서버 측에서 JavaScript를 실행할 수 있도록 하는 런타임이며, Express는 이를 위한 경량 웹 프레임워크입니다.',
  },
  {
    id: ts + 4,
    no: 4,
    title: 'MongoDB 기본 개념',
    content:
      'MongoDB는 NoSQL 데이터베이스로 JSON과 유사한 문서 기반 데이터를 저장하고 관리할 수 있습니다.',
  },
  {
    id: ts + 5,
    no: 5,
    title: '프론트엔드와 백엔드의 차이',
    content:
      '프론트엔드는 사용자가 보는 부분을 개발하는 것이고, 백엔드는 서버와 데이터베이스를 관리하는 부분입니다.',
  },
  {
    id: ts + 6,
    no: 6,
    title: '비동기 프로그래밍',
    content:
      'JavaScript의 비동기 처리 방식에는 콜백, 프로미스, async/await가 있습니다.',
  },
  {
    id: ts + 7,
    no: 7,
    title: 'Vue Router 사용법',
    content:
      'Vue Router를 사용하면 Vue.js 애플리케이션에서 페이지 이동을 쉽게 처리할 수 있습니다.',
  },
  {
    id: ts + 8,
    no: 8,
    title: '컴포넌트 기반 개발',
    content:
      'Vue.js에서는 컴포넌트를 사용하여 UI를 작은 단위로 쪼개서 관리할 수 있습니다.',
  },
  {
    id: ts + 9,
    no: 9,
    title: 'CSS와 SCSS 차이점',
    content: 'SCSS는 CSS의 확장된 버전으로 변수, 중첩, 믹스인 등을 지원합니다.',
  },
  {
    id: ts + 10,
    no: 10,
    title: 'Git과 GitHub 사용법',
    content:
      'Git은 버전 관리 시스템이며, GitHub는 이를 활용한 원격 저장소 플랫폼입니다.',
  },
]);

// no 내림차순 정렬
const sortedPosts = computed(() => {
  return [...posts.value].sort((a, b) => b.no - a.no);
});

const addPost = (newPost) => {
  // ...newPost로 기존 데이터를 펼치고, no를 덮어씌우기
  posts.value.push({
    ...newPost,
    no: posts.value.length + 1,
  });
};

const modifyPost = (id) => {
  const item = posts.value.find((item) => item.id === id);
  tempTitle.value = item.title;
  tempContent.value = item.content;
  modifyid.value = id;
};
const saveModify = (value) => {
  const item = posts.value.find((item) => item.id === value.id);
  item.title = value.title;
  item.content = value.content;
  modifyid.value = null;
};
const cancelModify = (value) => {
  const item = posts.value.find((item) => item.id === value.id);
  item.title = tempTitle.value;
  item.content = tempContent.value;
  modifyid.value = null;
};
const deletePost = (id) => {
  if (confirm('정말로 삭제하시겠습니까?')) {
    const index = posts.value.findIndex((item) => item.id === id);
    posts.value.splice(index, 1);
  }
};
</script>
