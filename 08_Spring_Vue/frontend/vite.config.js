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
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      "/api": {
        target: 'http://localhost:8080',
      },
    },
  },
  build: {
    // 빌드 후 저장될 디렉토리 위치 
    outDir:"C:/Users/student/Documents/GitHub/kim-hea-jin/08_Spring_Vue/backend/src/main/webapp/resources",
    emptyOutDir: true,  // 기존 파일 삭제 여부 (true: 삭제, false: 유지(덮어쓰기))
  },
});
