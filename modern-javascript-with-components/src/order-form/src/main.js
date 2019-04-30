import Vue from 'vue'
import OrderForm from './components/OrderForm.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(OrderForm)
}).$mount('#app')
