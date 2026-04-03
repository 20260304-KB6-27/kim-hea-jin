<template>
    <!-- params 전달 -->
  <RouterLink
    v-for="m in members"
    :key="m.id"
    :to="{ name: 'members-nested/detail', params: { id: m.id } }"
    class="m-2"
    >
  <!-- 이름 클릭 시 이동 -->
    {{ m.name }}
</RouterLink>
  <!-- 
   자식 라우트 
    - MemberDefault.vue
    - MemberDetail.vue
   -->
  <RouterView></RouterView>
</template>

<script setup>
import members from '@/members.json';
</script>

<style scoped></style>
