<template>
  <h1>Members</h1>
  <div v-for="m in members" :key="m.id">
    <RouterLink :to="{ name: 'members/id', params: { id: m.id } }">
      <img :src="m.photo" style="width: 90px; height: 110px" />
      <h6>{{ m.name }}</h6>
    </RouterLink>
  </div>
</template>

<script setup>
// src/members.json file 읽어옴
import members from '@/members.json';
</script>

<style scoped></style>
