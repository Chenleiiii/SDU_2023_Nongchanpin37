import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import axios from 'axios'
import './less/reset.less'
import '@/assets/global.css'
import '@/assets/font/font.css'
import preventMultiClick from './utils/preventMultiClick';

Vue.use(preventMultiClick)
Vue.config.productionTip = false
Vue.prototype.axios = axios;
Vue.use(ElementUI)


new Vue({
  router,
  store,

  render: h => h(App)
}).$mount('#app')
