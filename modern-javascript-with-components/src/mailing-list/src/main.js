import Vue from 'vue'
import MailingList from './components/MailingList.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(MailingList)
}).$mount('#app')
