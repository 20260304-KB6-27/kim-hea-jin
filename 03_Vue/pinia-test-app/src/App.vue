<template>
  <!-- count: {{ store.count }} <br />
  double.count: {{ store.doubleCount }} <br />
  <button @click="store.increment">increment</button> -->

  <!-- 분해할당 -->
  <!-- count: {{ count }} <br />
  double.count: {{ doubleCount }} <br />
  <button @click="increment">increment</button> -->

  <!-- 반응성 유지하면서 표현 압축 -->
  <!-- count: {{ store.count }} <br />
  double.count: {{ doubleCount }} <br />
  <button @click="increment">increment</button> -->

  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가 : <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
// stores/counter.js에서 export한 useCounterStore import
// import { useCounterStore } from '@/stores/counter.js';

// // useCounterStore 호출 -> store.[count, doubleCount, increment] 사용가능
// const store = useCounterStore();

// console.log(store);
// console.log(store.count);
// // 비권장
// // store.count = 10;

// 분해할당
// action 함수는 정상, 상태 변수는 반응성 잃음 (복사한 값이므로)
// const {count, doubleCount, increment} = useCounterStore();

// // 코드 축약 -> action만 분해할당
// const { increment } = useCounterStore();
// const store = useCounterStore();
// const doubleCount = computed(() => store.doubleCount);

import { useTodoListStore } from './stores/todoList';
import { ref, computed } from 'vue';

const todo = ref('');

const todoListStore = useTodoListStore();

// 분해할당
// todoList: 참조 배열이므로 반응성 유지
// src/stores/todoList.js 에서 const todoList = computed(()=> state.todoList);
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

const doneCount = computed(() => todoListStore.doneCount);
const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>

<style scoped></style>
