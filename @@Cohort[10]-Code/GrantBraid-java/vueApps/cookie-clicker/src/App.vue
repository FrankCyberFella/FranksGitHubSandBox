<template>
  <div id="app">
    <cookie-click/>
  </div>
</template>

<script>
import CookieClick from './components/CookieClick.vue'

export default {
  name: 'app', 
  components: {
    CookieClick
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
