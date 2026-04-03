<template>
  <div>
    <button @click="requestAxios">axios 버튼</button>
    <button @click="requestFetch">fetch 버튼</button>
  </div>
</template>

<script setup>
import axios from 'axios';

const url = '/api/todos';

// axios.get()은 비동기함수이므로 결과 바로 반환X, Promise 객체 반환
// const response = axios.get(url);
// console.log('response', response);
const requestAxios = () => {
  axios.get(url).then((response) => {
    console.log(`[axios] 응답객체: `, response);
    console.log(`[axios] 응답객체: `, response.data);
  });
};

const requestFetch = () => {
  fetch(url).then((response) => response.json())  // 역직렬화 (받아온 data json으로 변환)
  .then((data)=>{
    console.log('[fetch] 응답: ', data);
  });
};
</script>

<style scoped></style>
