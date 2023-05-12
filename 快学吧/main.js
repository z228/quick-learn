import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import request from 'common/request.js'
Vue.prototype.$request = request 
// import VueTinymce from "@packy-tang/vue-tinymce";

Vue.use(ElementUI);
// Vue.use(VueTinymce);

// #ifndef VUE3

Vue.config.productionTip = false;
App.mpType = 'app';
const app = new Vue({
    ...App
});
app.$mount();
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app,
	render: h => h(App)
  }
}
// #endif