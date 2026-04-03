import 'bootstrap/dist/css/bootstrap.min.css'; // 부트스트랩 추가

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(router);

app.mount('#app');
