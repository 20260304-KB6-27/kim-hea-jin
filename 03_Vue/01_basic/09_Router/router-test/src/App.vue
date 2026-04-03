<script setup>
import { RouterView, RouterLink } from 'vue-router';
import Header from './components/Header.vue';
</script>

<template>
  <Header></Header>
  <!-- 각 경로별 컴포넌트를 랜더링 할 위치를 정하는 컴포넌트 -->
   <RouterView></RouterView>
</template>

<style scoped>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css');
.fa {
  padding: 5px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}
.fa-facebook {
  background: #3b5998;
  color: white;
}
.fa-youtube {
  background: #bb0000;
  color: white;
}
.fa-instagram {
  background: #125688;
  color: white;
}
</style>
