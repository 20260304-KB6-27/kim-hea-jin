<template>
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script setup>
// defineProps: 부모요소에서 전달받은 Props를 정의하는 함수
// 유효성 검사
defineProps({
  idol: {
    type: Object,
    required: true,

    // Vue 공식 기능
    // 부모가 props 전달할 떄마다 함수 호출
    // 반환값이 false일 경우 console에 경고 출력
    validator: (value) => {
      return (
        (typeof value.id === 'number' || typeof value.id === 'string') &&
        typeof value.name === 'string' &&
        typeof value.checked === 'boolean'
      );
    },
  },
});
</script>

<style lang="scss" scoped></style>
