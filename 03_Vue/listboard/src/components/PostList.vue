<template>
  <ul>
    <PostListItem
      v-for="postitem in sortedPosts"
      :key="postitem.id"
      class="post-item"
      :postitem="postitem"
      :modifyid="modifyid"
      @modify="modifyPost"
      @save="saveModify"
      @cancel="cancelModify"
      @delete="deletePost"
    ></PostListItem>
    <!-- PostList는 중계자 역할 -->
    <!-- 자식 PostListItem에서 받은 이벤트 modify, save, cancel, delete를 
     부모 App에서 받은 함수 modifyPost, saveModify, cancelModify, deletePost와 연결 -->
  </ul>
</template>

<script setup>
import PostListItem from './PostListItem.vue';

// 부모 App -> 자식 PostList 로 받은 sortedPosts props로 정의
const props = defineProps({
  sortedPosts: Array,
  modifyid: Number,
});

// PostListItem -> PostList -> App
const emit = defineEmits(['modify', 'save', 'cancel', 'delete']);
const modifyPost = (id) => {
  emit('modify', id);
};
const saveModify = (value) => {
  emit('save', value);
};
const cancelModify = (value) => {
  emit('cancel', value);
};
const deletePost = (id) => {
  emit('delete', id);
};
</script>
