<!-- 부모: SlotTest, 자식: CheckBox2 -->
<template>
  <div>
    <h3>당신이 경험한 프론트엔드기술은? (Slot 사용 O)</h3>

    <!-- v-for 사용해 items 나열, 각 속성 props로 전달 -->
    <CheckBox2
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :checked="item.checked"
      :label="item.label"
      @check-changed="checkBoxChanged"
    >
    <!-- 부모에서 정의한 템플릿, 자식의 slot 위치에 들어감 -->
    <p>내용 추가</p>
    </CheckBox2>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import CheckBox2 from './CheckBox2.vue';

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
