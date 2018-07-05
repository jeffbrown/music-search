import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import {DEV_SERVER_URL, PROD_SERVER_URL} from './config'

Vue.use(VueResource);

if (process.env.NODE_ENV !== 'production') {
  Vue.http.options.root = DEV_SERVER_URL
} else {
  Vue.http.options.root = PROD_SERVER_URL
}
new Vue({
  el: '#app',
  render: h => h(App)
});
