import { createApp } from 'vue'

// axios - get 요청
// import App from './App.vue'

// axios - post 요청
import App from './App2.vue'
import router from './router'

const app = createApp(App)

app.use(router)

app.mount('#app')
