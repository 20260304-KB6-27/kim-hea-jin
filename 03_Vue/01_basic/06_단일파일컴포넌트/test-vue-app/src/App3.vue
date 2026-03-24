<template>
  <div>
    <h2>App Component</h2>
    <hr />
    <ul>
      <CheckboxItem v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import CheckboxItem from './components/CheckboxItem3.vue';

const idols = ref([
  { id: 1, name: 'BTS', checked: true },
  { id: 2, name: 'Black Pink', checked: false },
  { id: 3, name: 'EXO', checked: false },
  { id: 4, name: 'ITZY', checked: false },
  { id: 5, checked: false },
  { id: 6, name: 'NCT' },
]);
</script>

<style lang="scss" scoped></style>
