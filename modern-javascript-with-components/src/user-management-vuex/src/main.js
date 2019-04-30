import Vue from 'vue'
import NewUser from './components/NewUser.vue'
import UserFilter from './components/UserFilter.vue'
import UserTable from './components/UserTable.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(NewUser)
}).$mount('new-user');

new Vue({
  render: h => h(UserFilter)
}).$mount('user-filter');

new Vue({
  render: h => h(UserTable)
}).$mount('user-table');
