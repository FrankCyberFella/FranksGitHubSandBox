import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')

const liItems= document.querySelectorAll('li');

liItems.forEach((item) => {
  item.addEventListener('click', () => {
    if(!item.classList.contains('completed')) {
      item.classList.add('completed');
    }
  })
});