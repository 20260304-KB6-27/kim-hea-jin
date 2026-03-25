<template>
  <div>
    <input type="checkbox" :value="id" :checked="checked" @change="onChange" />

    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
      ><i>{{ label }}</i></span
    >

    <span v-else style="color: gray"
      ><i>{{ label }}</i></span
    >
  </div>
</template>

<script setup>
// 부모에서 전달받은 data props로 정의
const props = defineProps(['id', 'checked', 'label']);

// 부모에게 보낼 이벤트 emit으로 정의
const emit = defineEmits(['check-changed']);

function onChange(event) {
    emit('check-changed', {id: props.id, checked: event.target.checked});
};
</script>

<style lang="scss" scoped></style>
