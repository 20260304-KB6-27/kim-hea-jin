<template>
  <li><input type="checkbox" v-model="checked" /> 옵션</li>
</template>

<!-- <script> 태그에 setup 사용 안 했을 때
<script>
import { ref } from 'vue';

const checked = ref(false);

export default {
    name: "CheckboxItem",
    setup() {
        const checked = ref(false);

        return {checked};
    },
};
</script> -->

<script setup>
import { ref } from 'vue';

// 반응형 변수 설정
const checked = ref(false);
</script>

<style lang="scss" scoped></style>
