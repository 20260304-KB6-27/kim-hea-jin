<template>
  <h2>2. Scoped(범위) CSS</h2>
  <div class="box">Scoped CSS가 적용된 박스입니다.</div>
</template>

<script setup></script>

<style scoped>
/* Scopped 속성
 - 이 컴포넌트에만 스타일 적용
 - Vue가 datav-해시값 속성 생성해 적용
 - 다른 컴포넌트의 같은 클래스명과 충돌X 
 */
.box {
  padding: 20px;
  background-color: aliceblue;
  border: 2px solid green;
}
</style>
