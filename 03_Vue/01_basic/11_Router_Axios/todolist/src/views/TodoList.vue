<template>
  <!-- todo 추가 버튼(AddTodo로 이동) -->
  <div class="row">
    <div class="col p-3">
      <RouterLink class="btn btn-primary" to="/todos/add">
        할일 추가
      </RouterLink>
    </div>
  </div>

  <!-- 목록 보여주기 -->
  <div class="row">
    <div class="col p-3">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import TodoItem from '@/components/TodoItem.vue'; 
import { inject } from 'vue'; 

// App.vue에서 provide한 todoList inject로 받아옴
const todoList = inject('todoList');
</script>

<style scoped></style>
