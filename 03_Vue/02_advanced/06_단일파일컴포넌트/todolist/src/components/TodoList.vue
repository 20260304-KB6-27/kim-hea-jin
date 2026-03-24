<template>
  <ul>
    <TodoListItem
      v-for="todoitem in todolist"
      :key="todoitem.id"
      :todoitem="todoitem"
      @toggle="toggleCompleted"
      @delete="deleteTodo"
    >
    </TodoListItem>
  </ul>
</template>

<script setup>
import TodoListItem from './TodoListItem.vue';

const props = defineProps({
  todolist: Array,
});

// App component로 보내는 emit
const emit = defineEmits(['toggle', 'delete']);

const toggleCompleted = (id) => {
  emit('toggle', id);
};
const deleteTodo = (id) => {
  emit('delete', id);
};
</script>
