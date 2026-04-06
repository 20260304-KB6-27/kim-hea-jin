<template>
  <div class="card card-body">
    <h2>MemberInfo</h2>
    <!-- <div>
      경로 패턴: /members/:id <br />
      요청 경로: {{ currentRoute.path }} <br />
      id값: {{ currentRoute.params.id }} <br />
    </div> -->
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import members from '@/members.json';

const currentRoute = useRoute();

// 동적 파라미터 id를 얻어 해당 멤버의 정보 찾기
const id = parseInt(currentRoute.params.id, 10);
const member = members.find((m) => m.id === id);
</script>

<style scoped></style>
