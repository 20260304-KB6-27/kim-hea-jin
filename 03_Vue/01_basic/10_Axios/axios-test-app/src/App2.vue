<template>
  <div>
    <button @click="requestAxios">axios 버튼</button>
  </div>
</template>

<script setup>
import axios from 'axios';

const url = '/api/todos';

const data = {
  todo: 'await 윗몸 일으키기',
  desc: '어쩌고저쩌고',
};

// post 요청 (status: 201 확인 -> db.json에 추가됨)
// const requestAxios = () => {
//   axios.post(url, data).then((response) => {
//     console.log(`[axios] 응답데이터: `, response.data);
//   });
// };

// async await 적용
const requestAxios = async () => {
  const response = await axios.post(url, data);
  console.log('응답 데이터 : ', response);
};
</script>

<style scoped></style>
