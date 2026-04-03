<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// const requestAPI = () => {
//   // const url = 'http://localhost:3000/todos/1';
//   const url = '/api/todos/1';
//   axios.get(url).then((response) => {
//     console.log('# 응답객체 : ', response);
//     console.log(typeof response.data);  // object 출력
//   });
// };

// 목록 -> 상세 순차 조회 (API 호출 여러번)
// const requestAPI = async () => {
//   let todoList;
//   let response = await axios.get(listUrl);
//   todoList = response.data;
//   console.log('# TodoList : ', todoList);
//   for (let i = 0; i < todoList.length; i++) {
//     response = await axios.get(todoUrlPrefix + todoList[i].id);
//     console.log(`# ${i + 1}번째 Todo : `, response.data);
//   }
// };

// 한 번에 전체 조회 (API 1번 호출)
// const requestAPI = async () => {
//   const url = '/api/todos/2';
//   const response = await axios.get(url);
//   console.log('# 응답객체 : ', response); // object 출력
// };

const requestAPI = async () => {
  const url = '/api/todos';
  let data = { todo: '윗몸일으키기 3세트', desc: '너무 빠르지 않게...' };
  const resp1 = await axios.post(url, data);
  console.log(resp1.data);
};

requestAPI();
</script>

<style scoped></style>
