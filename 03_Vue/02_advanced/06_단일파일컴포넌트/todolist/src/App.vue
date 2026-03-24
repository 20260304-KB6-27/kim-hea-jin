<template>
  <h1>:: ToDoList App::</h1>

  <!-- 입력 컴포넌트 -->
  <InputTodo @add="addTodo"></InputTodo>

  <!-- 목록 출력 컴포넌트 -->
  <div>
    <TodoList
      :todolist="todolist"
      @toggle="toggleCompleted"
      @delete="deleteTodo"
    ></TodoList>
  </div>
</template>

<script setup>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
import { ref } from 'vue';

let ts = new Date().getTime();

const todolist = ref([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
]);

const deleteTodo = (id) => {
  let index = todolist.value.findIndex((item) => id === item.id);
  todolist.value.splice(index, 1);
};

const toggleCompleted = (id) => {
  let index = todolist.value.findIndex((item) => id === item.id);
  todolist.value[index].completed = !todolist.value[index].completed;
};

const addTodo = (newTodo) => {
  todolist.value.push(newTodo);
};
</script>
