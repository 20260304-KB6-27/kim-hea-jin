<template>
  <li @click="toggleCompleted(todoitem.id)">
    <span
      :style="{ textDecoration: todoitem.completed ? 'line-through' : 'none' }"
      >{{ todoitem.todo }} {{ todoitem.completed ? '[완료]' : '' }}</span
    >

    <!-- 삭제하기 -->
    <button @click="deleteTodo(todoitem.id)">삭제</button>
  </li>
</template>

<script setup>
const props = defineProps({
  todoitem: Object,
});

// Todolist로 보내는 emit
const emit = defineEmits(['toggle', 'delete']);

// 어떤게 클릭되었는지 Todolist로 전달
const toggleCompleted = (id) => {
  emit('toggle', id);
};
const deleteTodo = (id) => {
  emit('delete', id);
};
</script>
