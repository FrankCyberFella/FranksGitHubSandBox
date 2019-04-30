import Vue from 'vue'
import App from './App.vue' //go get the code at './App.Vue' and I'm gonna call it App

Vue.config.productionTip = false

new Vue({
  render: h => h(App), // render attribute tells Vue to "display the html in the Vue app with  the name given"
}).$mount('#app')
