<template>
  <div class="container">
    <Header />
    <!-- page component 보여지는 곳 -->
    <router-view />
    <!-- loading component 보여지는 곳 -->
    <Loading v-if="states.isLoading" />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
// loading component 추가
import Loading from '@/components/Loading.vue';
// axios import 추가
import axios from 'axios';

const BASEURL = '/api/todos';
const states = reactive({ todoList: [], isLoading: false });

// TodoList 목록 조회
const fetchTodoList = async () => {
  states.isLoading = true;
  try {
    const response = await axios.get(BASEURL);
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert('데이터조회실패');
    }
  } catch (error) {
    alert('에러발생:' + error);
  }
  states.isLoading = false;
};

// 새로운 TodoItem 추가
const addTodo = async ({ todo, desc }, successCallback) => {
  states.isLoading = true;
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURL, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

// 기존 TodoItem 변경
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  states.isLoading = true;
  try {
    const payload = { id, todo, desc, done };
    const response = await axios.put(BASEURL + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert('Todo 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

// 기존 TodoItem 삭제
const deleteTodo = async (id) => {
  states.isLoading = true;
  try {
    const response = await axios.delete(BASEURL + `/${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

// 기존 TodoItem의 완료여부(done) 값 토글
const toggleDone = async (id) => {
  states.isLoading = true;
  try {
    let todo = states.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, done: !todo.done };
    const response = await axios.put(BASEURL + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

fetchTodoList();
</script>
