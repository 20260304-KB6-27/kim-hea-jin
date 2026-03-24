<template>
  <input
    type="text"
    v-model.trim="todo"
    @keyup.enter.exact="addTodo"
    @keyup.ctrl.enter.exact="addTodo"
  />
  <button @click="addTodo">추가</button>
</template>

<script setup>
import { ref } from 'vue';

// 입력값을 반응형변수 todo로 가져오기
const todo = ref('');

const emit = defineEmits(['add']);

const addTodo = (e) => {
  if (todo.value === '') return;

  emit('add', {
    id: new Date().getTime(),
    todo: todo.value,
    completed: e.ctrlKey ? true : false,
  });

  todo.value = '';
};
</script>
