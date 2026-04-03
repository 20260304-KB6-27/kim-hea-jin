<template>
  <!-- 멤버가 있을 때 -->
  <div v-if="member">
    <img :src="member.photo" alt="" />
    <h2>{{ member.name }}</h2>
    <h2>{{ member.role }}</h2>
    <h2>{{ member.desc }}</h2>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import members from '@/members.json';
import { computed } from 'vue';

const route = useRoute();
const member = computed(() => 
  // 전달된 params 꺼내와 id 비교해 해당 member 찾기
  members.find((m) => m.id === Number(route.params.id))
);
</script>

<style scoped></style>
