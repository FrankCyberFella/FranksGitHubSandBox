import Vue from 'vue'
import App from './App.vue'
import FirstComponent from './components/first-component.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')

new Vue({
  render: h => h(FirstComponent)
}).$mount('first-component')