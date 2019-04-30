<template>
    <div id="app">
      <my-counter/>
    </div>
</template>

<script>
import MyCounter from '@/componenets/MyCounter';

export default {
  name: 'app',
  componenets: {
    MyCounter
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
