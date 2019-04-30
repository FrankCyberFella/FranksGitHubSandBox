import Vue from 'vue'
import UserManager from './UserManager.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(UserManager)
}).$mount('#app')
