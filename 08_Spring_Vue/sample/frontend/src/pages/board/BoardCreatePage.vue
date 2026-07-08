<script setup>
import boardApi from '@/api/boardApi';
import { computed, reactive, ref, onMounted } from 'vue'; // onMounted 추가
import { useAuthStore } from '@/stores/auth';
import { useRoute, useRouter } from 'vue-router';

// Toast UI Editor 사용
import '@toast-ui/editor/dist/toastui-editor.css';
import Editor from '@toast-ui/editor';

const auth = useAuthStore();
const router = useRouter();
const cr = useRoute();

const files = ref(null);
const editorContainer = ref(null); // 에디터가 그려질 div 요소를 가리킴
let editorInstance = null; // 생성된 에디터 객체를 담을 변수

const article = reactive({
  writer: auth.username,
  title: '',
  files: null,
  content: '',
});

const disableSubmit = computed(() => !article.title);

// 화면 렌더링 직후 에디터 생성
onMounted(() => {
  editorInstance = new Editor({
    el: editorContainer.value, // ref="editorContainer"인 div에 마운트
    height: '500px',
    initialEditType: 'wysiwyg',
    previewStyle: 'vertical',
  });
});

const submit = async () => {
  if (!confirm('등록할까요?')) return;

  // 생성된 에디터 인스턴스에서 HTML 내용을 가져옵니다.
  article.content = editorInstance.getHTML();

  if (files.value.files.length > 0) {
    article.files = files.value.files;
  }

  await boardApi.create(article);
  router.push('/board/list');
};
</script>

<template>
  <h1><i class="fa-regular fa-pen-to-square"></i> 글 작성</h1>

  <form @submit.prevent="submit">
    <div class="mb-3 mt-3">
      <label for="title" class="form-label"> 제목 </label>
      <input
        type="text"
        class="form-control"
        id="title"
        v-model="article.title"
      />
    </div>

    <div class="mb-3 mt-3">
      <label for="files" class="form-label"> 첨부파일 </label>
      <input type="file" class="form-control" id="files" ref="files" multiple />
    </div>

    <!-- 빈 div를 만들고 ref로 연결합니다 -->
    <div class="mb-3 mt-3">
      <label class="form-label"> 내용 </label>
      <div ref="editorContainer"></div>
    </div>

    <div class="my-5 text-center">
      <button
        type="submit"
        class="btn btn-primary me-3"
        :disabled="disableSubmit"
      >
        <i class="fa-solid fa-check"></i> 확인
      </button>
      <router-link
        class="btn btn-primary"
        :to="{ name: 'board/list', query: cr.query }"
      >
        <i class="fa-solid fa-list"></i> 목록
      </router-link>
    </div>
  </form>
</template>
