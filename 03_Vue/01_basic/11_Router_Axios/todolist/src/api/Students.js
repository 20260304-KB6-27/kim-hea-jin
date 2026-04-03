// import axios from 'axios';

import axios from '@/utils/axios';
import { ref } from 'vue';

/* 
컴포저블 함수
훈련생 데이터를 관리하는 함수
*/
export const useStudent = () => {
  const students = ref([]);

  // 전체조회
  const fetchAllStudents = async () => {
    // const response = await axios.get('/api/students');

    // axios.js의 baseURL 설정으로 /api 안 써도 됨
    const response = await axios.get('/students');
    students.value = response.data;
  };
  return { fetchAllStudents, students };
};
