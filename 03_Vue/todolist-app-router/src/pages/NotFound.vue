<template>
    <div class="m-3">
        <h3>존재하지 않는 경로</h3>
        <p>요청 경로 : {{currentRoute.path}}</p>
    </div>
</template>

<script setup>
// useRoute 사용해 현재 route 정보 확인
import { useRoute } from 'vue-router'
const currentRoute = useRoute();
</script>