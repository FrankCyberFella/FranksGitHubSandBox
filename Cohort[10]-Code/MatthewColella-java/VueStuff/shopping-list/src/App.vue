<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <ShoppingList></ShoppingList>
  </div>
</template>

<script>
import ShoppingList from './components/ShoppingList.vue'
export default {
  name: 'app',
  components: {
    ShoppingList
  }
}
</script>

<style>
body {
  background: #35495e;
  background: radial-gradient(circle, #000000 50%,
#5bb884 100%);
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
