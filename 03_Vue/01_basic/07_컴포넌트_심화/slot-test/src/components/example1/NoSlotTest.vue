<!-- 부모: NoSlotTest, 자식: CheckBox1 -->
<template>
  <div>
    <h3>당신이 경험한 프론트엔드기술은? (Slot 사용 X)</h3>

    <!-- v-for 사용해 items 나열, 각 속성 props로 전달 -->
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :checked="item.checked"
      :label="item.label"
      @check-changed="checkBoxChanged"
    ></CheckBox1>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import CheckBox1 from './CheckBox1.vue';

const items = ref([
  { id: 'V', checked: true, label: 'Vue' },
  { id: 'A', checked: false, label: 'Angular' },
  { id: 'R', checked: false, label: 'React' },
  { id: 'S', checked: false, label: 'Svelte' },
]);

function checkBoxChanged(e) {
  let item = items.value.find((item) => item.id === e.id);
  item.checked = e.checked;
}
</script>

<style lang="scss" scoped></style>
