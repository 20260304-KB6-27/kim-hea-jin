<template>
  <div>
    <!-- 
    Routerink
     - 클릭하면 페이지 이동
     - to 속성에 이동할 경로 지정 
    -->
    <RouterLink to="/">Home</RouterLink> |
    <RouterLink to="/members">members</RouterLink> |
    <RouterLink :to="{name: 'members-nested'}">members-nested</RouterLink>
  </div>
</template>

<script setup>



</script>

<style scoped>



</style>