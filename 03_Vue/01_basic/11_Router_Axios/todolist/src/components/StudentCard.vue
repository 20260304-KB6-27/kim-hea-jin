<template>
  <div class="simple-card">
    <h5>{{ student.name }}</h5>
    <div class="email"><i class="bi bi-envelope"></i>{{ student.email }}</div>
    <div class="team"><i class="bi bi-people"></i>{{ student.team }}</div>
  </div>
</template>
<script setup>
// Students
const props = defineProps({
  student: {
    type: Object,
    required: true,
  },
});
</script>

<style scoped>
.simple-card {
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #eee;
  border-radius: 4px;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s;
}
.simple-card:hover {
  background-color: #f5f5f5;
}
.email {
  margin-top: 5px;
  font-size: 0.9rem;
  color: #666;
}
.team {
  margin-top: 5px;
  font-size: 0.9rem;
  color: #666;
}
</style>
