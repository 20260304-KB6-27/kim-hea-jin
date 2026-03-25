<template>
  <li class="post-item">
    <span>
      <span @click="toggle(postitem.id)">
        {{ postitem.no }}. {{ postitem.title }}
        {{ selectid == postitem.id ? '▼' : '▲' }}
      </span>

      <!-- 클릭 시 & 수정 중 아닐 때 content 보이기 -->
      <div
        v-if="selectid == postitem.id && modifyid !== postitem.id"
        class="post-content"
      >
        <p>{{ postitem.title }}</p>
        <p>{{ postitem.content }}</p>
        <!-- 자식 PostListItem에서 부모 PostList로 이벤트 올리기(emit) -->
        <button @click.stop="emit('modify', postitem.id)">수정</button>
        <button @click.stop="emit('delete', postitem.id)">삭제</button>
        <button @click.stop="selectid = null">닫기</button>
      </div>

      <!-- 수정 버튼 클릭 -->
      <div v-if="modifyid == postitem.id" class="d-flex flex-column gap-2">
        <input type="text" v-model="postitem.title" />
        <textarea v-model="postitem.content" rows="4"></textarea>
        <div class="d-flex gap-2">
          <button @click.stop="emit('save', postitem)">저장</button>
          <button @click.stop="emit('cancel', postitem)">취소</button>
        </div>
      </div>
    </span>
  </li>
</template>

<script setup>
import { ref } from 'vue';
const selectid = ref(null);

// 부모 PostList으로부터 받은 postitem props로 정의
const props = defineProps({
  postitem: Object,
  modifyid: Number,
});

const toggle = (id) => {
  selectid.value = selectid.value === id ? null : id;
};

// PostListItem -> PostList
const emit = defineEmits(['modify', 'save', 'cancel', 'delete']);
</script>
