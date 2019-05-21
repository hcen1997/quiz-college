import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueDarkMode from 'vuedarkmode'
import axios from 'axios'
import store from './store'

Vue.use(VueDarkMode)
Vue.config.productionTip = false
// axios.defaults.baseURL = 'https://' + 'hcen.xyz' + '/api'
axios.defaults.baseURL = 'http://localhost:8001/api'
Vue.prototype.$axios = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
