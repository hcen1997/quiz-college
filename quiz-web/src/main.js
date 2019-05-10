import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueDarkMode from 'vuedarkmode'
Vue.use(VueDarkMode)
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
