import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  server: {
    // 프록시 설정: CORS 문제를 우회하기 위해 요청을 다른서버로 중계하는 역할
    proxy: {
      // /api로 시작하는 모든 요청을 아래 설정에 따라 처리
      // ex) App.vue에 const url = '/api/todos'; 설정 시 http://localhost:3000/todos로 이동
      "/api": {
        // target: 실제 요청을 보낼 백엔드 서버 주소
        target: "http://localhost:3000",

        // 요청 헤더의 origin을 taget 주소로 변경
        changeOrigin: true, 
        // url 재작성 (/api 경로 제거후 전달)
        rewrite: (path) => path.replace(/^\/api/, "")
      }
    }
  }
})
