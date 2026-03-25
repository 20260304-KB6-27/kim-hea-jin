<template>
  <div>
    <input type="checkbox" :value="id" :checked="checked" @change="onChange" />
    <!-- slot: 부모 컴포넌트에서 정의한 템플릿 요소들이 들어오는 장소 -->
    <slot>
      <!-- label: 부모에서 템플릿을 정의 안 한 경우 표시될 기본값 -->
      {{ label }}
    </slot>
  </div>
</template>

<script setup>
// 부모에서 전달받은 props 정의
const props = defineProps(['id', 'checked', 'label']);

const emit = defineEmits(['check-changed']);

function onChange(event) {
  emit('check-changed', { id: props.id, checked: event.target.checked });
}
</script>

<style lang="scss" scoped></style>
