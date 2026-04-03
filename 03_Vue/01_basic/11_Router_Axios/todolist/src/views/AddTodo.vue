<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <!-- htmlFor: label과 input을 연결(id=todo) -->
        <label htmlFor="todo">할일:</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명:</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

// actions 객체 안의 addTodo 함수 구조분해할당으로 가져옴
const { addTodo } = inject('actions');

// 페이지 이동 -> 이동경로 필요하므로 useRouter() 사용
const router = useRouter();

// 할일 추가 변수 (v-model로 연결, 여기서만 사용)
// reactive 객체 변수
const todoItem = reactive({ todo: '', desc: '' });

// 할일 추가 버튼 핸들러
const addTodoHandler = () => {
  // todoItem을 값만 복사해 객체로 전달
  addTodo({ ...todoItem });

  // 목록화면으로 이동
  router.push('/todos');
};
</script>

<style scoped></style>
