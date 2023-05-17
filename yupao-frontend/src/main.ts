import { createApp } from 'vue'
// @ts-ignore
import App from './App.vue'
import { Button, NavBar, Icon, Toast } from 'vant';

const app = createApp(App);
app.use(Icon);
app.use(Toast);
app.use(Button);
app.use(NavBar);

app.mount('#app');
