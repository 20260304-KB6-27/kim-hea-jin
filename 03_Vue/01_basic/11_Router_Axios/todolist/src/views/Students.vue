<template>
  <h2>KB - 27회차 훈련생들</h2>
  <div v-for="student in students" :key="student.id">
    <StudentCard :student="student"></StudentCard>
  </div>
</template>

<script setup>
// api/Students.js에서 export 한 useStudent import
import { useStudent } from '@/api/Students.js';
import StudentCard from '@/components/StudentCard.vue';
import { onMounted } from 'vue';

const {students, fetchAllStudents} = useStudent();

onMounted(() => {
    fetchAllStudents();
})

</script>

<style scoped>



</style>