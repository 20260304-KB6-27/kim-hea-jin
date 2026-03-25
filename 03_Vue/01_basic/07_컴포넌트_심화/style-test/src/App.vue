<script setup>
import GlobalCssDemo from './components/GlobalCssDemo.vue';
import ScopedCssDemo from './components/ScopedCssDemo.vue';
import CssModuleDemo from './components/CssModuleDemo.vue';
</script>

<template>
  <div class="container">
    <h1>Vue CSS 스타일 방법</h1>
    <!-- Global(전역) CSS -->
    <GlobalCssDemo />

    <!-- Scoped CSS-->
    <ScopedCssDemo />

    <!-- CSS Module -->
    <CssModuleDemo />
  </div>
</template>

<!-- scoped 없으면 전역CSS나 마찬가지 -->
<!-- App.vue의 <style>: 전역처럼 동작,
 main.css와 역할 구분위해 주로 앱의 레이아웃 구성 -->
<style>
.container {
  max-width: 600px;
  margin: 40px auto;
}
</style>
