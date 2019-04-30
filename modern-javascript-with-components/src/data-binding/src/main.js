import Vue from 'vue'
import UserManagement from './components/UserManagement.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(UserManagement)
}).$mount('user-management');
