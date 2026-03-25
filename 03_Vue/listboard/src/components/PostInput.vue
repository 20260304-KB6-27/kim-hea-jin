<template>
  <div class="m-3 d-flex justify-content-center align-items-center gap-2">
    <input type="text" placeholder="새 게시글 제목" v-model="postTitle" />
    <input type="text" placeholder="새 게시글 제목" v-model="postContent" />
    <button @click="addPost">저장</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// 입력값 post로 가져오기
const postTitle = ref('');
const postContent = ref('');

// PostInput -> App
const emit = defineEmits(['add']);

const addPost = (e) => {
  if (postTitle.value === '' || postContent.value === '') return;
  emit('add', {
    id: new Date().getTime(),
    title: postTitle.value,
    content: postContent.value,
  });
  postTitle.value = '';
  postContent.value = '';
};
</script>
