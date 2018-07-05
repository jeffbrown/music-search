import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import 'bootstrap/dist/css/bootstrap.css'

Vue.use(VueResource);

if (process.env.NODE_ENV !== 'production') {
  Vue.http.options.root = 'http://localhost:8080'
}
new Vue({
  el: '#app',
  render: h => h(App)
});
