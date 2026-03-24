<template>
  <div>
    <h2>App Component</h2>
    <hr />
    <inputName @name-change="nameChangeHandler"></inputName>
    <h3>App Data : {{ parentName }}</h3>
  </div>
</template>

<script setup>
import inputName from './components/inputName.vue';
import { ref } from 'vue';

// 1. 자식 component에서 이벤트 발생 (이벤트 이름 : name-change)
// 2. 부모 component에서 이벤트 감지 (@name-change) -> 이때 이벤트 객체로 데이터를 전달 받을 수 있음
// 3. 부모 component의 이벤트 핸들러 동작 (nameChangeHandler) 
const parentName = ref('기본값');
const nameChangeHandler = (event) => {
  parentName.value = event.name;
};
</script>

<style lang="scss" scoped></style>
