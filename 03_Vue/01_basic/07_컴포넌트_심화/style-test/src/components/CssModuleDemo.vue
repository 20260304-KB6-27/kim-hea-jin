<template>
  <h2>3. CSS Module</h2>

  <!-- CSS Module은 객체처럼 사용 -->
  <div :class="$style.box">CSS Module이 적용된 박스입니다.</div>

  <div>style : {{ style }}</div>
</template>

<script setup>
import { useCssModule } from 'vue';

// Composition 방식 -> useCssModule()로 $style 객체 꺼내옴
const style = useCssModule();
</script>

<style module>
.box {
  padding: 20px;
  margin: 10px 0;
  border-radius: 8px;
  background-color: plum;
  border: 2px solid aliceblue;
}
</style>
