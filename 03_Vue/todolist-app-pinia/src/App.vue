<template>
  <div class="container">
    <Header />
    <!-- page component 보여지는 곳 -->
    <router-view />
    <!-- loading component 보여지는 곳 -->
    <Loading v-if="isLoading" />
  </div>
</template>

<script setup>
import { computed } from 'vue';
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';

// src/stores/todoList.js에서 export한 useTodoListStore 호출
import { useTodoListStore } from './stores/todoList';

// useTodoListStore 호출
//  -> return 값 todoListStore에 저장, 필요한 변수/함수 꺼내 쓸 수 있음
const todoListStore = useTodoListStore();

const isLoading = computed(()=>todoListStore.isLoading);

// todoList 목록 조회
const fetchTodoList = todoListStore.fetchTodoList;

fetchTodoList();
</script>
