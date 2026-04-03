<template>
  <div class="container">
    <Header></Header>
    <RouterView></RouterView>
  </div>
</template>

<script setup>
import Header from './components/Header.vue';
import axios from 'axios';

// (1) db.json 파일 직접 읽어옴
// import todoLists from '../db.json';

import { provide, reactive, computed, onMounted } from 'vue';

// (2) axios로 todolist 조회
const BASEURL = '/api/todos';

// 1. todoList 조회
// state: 반응형 데이터 (나중에 pinia로 전역상태 관리)
const state = reactive({
  todoLists: [],
});

// json-server에서 데이터 받아서 state에 저장하는 함수 선언
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURL);

    // 통신상태코드 200일 때
    if (response.status === 200) {
      console.log('response.data : ', response.data);
      state.todoLists = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (err) {
    alert('에러 발생 : ' + err);
  }
};

// 완료 <-> 미완료 토글
const toggleDone = (id) => {
  // todoList의 id와 이벤트핸들러로 받은 id 비교해 같은
  let index = state.todoLists.findIndex((item) => item.id === id);
  // 완료상태 수정
  state.todoLists[index].done = !state.todoLists[index].done;
};

// 2. todo 추가
// const addTodo = ({ todo, desc }) => {
//   state.todoLists.push({ id: Date.now(), todo, desc, done: false });
// };

const addTodo = async ({ todo, desc }) => {
  const payload = { todo, desc };
  const response = await axios.post(BASEURL, payload); // 권장: 예외처리 추가

  if (response.status === 201) {
    state.todoLists.push({ id: Date.now(), todo, desc, done: false });
  } else {
    alert("Todo 추가 실패");
  }
};

// todoList 변경 시 inject한 컴포넌트도 재랜더링
provide(
  'todoList',
  computed(() => state.todoLists),
);

// 상태값 변경 함수 하나의 객체 actions로 묶어 전달
provide('actions', { toggleDone, addTodo });

// DOM이 준비된 후에 초기데이터 준비
onMounted(() => {
  // 데이터 준비용
  fetchTodoList();
});
</script>

<style scoped></style>
