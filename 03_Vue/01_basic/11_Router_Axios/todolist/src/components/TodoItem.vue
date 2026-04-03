<template>
  <li
    :class="
      todoItem.done
        ? 'list-group-item list-group-item-success'
        : 'list-group-item'
    "
  > 
    <span
      :class="todoItem.done ? 'todo-done pointer' : 'pointer'"
      @click="toggleDone(todoItem.id)"
    >
      {{ todoItem.todo }}
      {{ todoItem.done ? '(완료)' : '' }}
    </span>
  </li>
</template>

<script setup>
import { inject } from 'vue';

// TodoList(부모)에서 todoItem 받아옴 (자식) -> defineProps
defineProps({
  todoItem: { Type: Object, required: true },
});

// actions(provide) 객체에서 toggleDone 함수 구조분해할당으로 꺼내기(inject)
const {toggleDone} = inject('actions');
</script>

<style scoped></style>
