<template>
  <h1>MemberInfo</h1>
  <!-- <div>
    경로패턴 : members/:id <br />
    요청경로 : {{ route.path }} <br />
    전달된 id : {{ route.params.id }}
  </div> -->

  <div>
    <img :src="member.photo" />
    <h4>{{ member.name }}{{ member.role }}</h4>
    <p>{{ member.desc }}</p>

    <!-- 인스타, 페북, 유튜브 있는 경우에만 아이콘 띄움 -->
    <a
      v-if="member.insta && member.insta !== ''"
      class="fa fa-instagram m-1"
      :href="member.insta"
    ></a>
    <a
      v-if="member.facebook && member.facebook !== ''"
      class="fa fa-facebook m-1"
      :href="member.facebook"
    ></a>
    <a
      v-if="member.youtube && member.youtube !== ''"
      class="fa fa-youtube m-1"
      :href="member.youtube"
    ></a>
  </div>
  <RouterLink to="/members">멤버목록으로</RouterLink>
</template>

<script setup>
import { useRoute } from 'vue-router';
import members from '@/members.json';

const route = useRoute();

// params의 id 읽어옴
const memberId = Number(route.params.id);

// params의 id 값 기준 보여줄 멤버 찾음
const member = members.find((m) => m.id === memberId);
</script>

<style scoped></style>
