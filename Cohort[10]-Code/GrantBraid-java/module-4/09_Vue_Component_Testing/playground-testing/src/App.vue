<template>
  <div id="app">
    <dans-awesome-counter/>
  </div>
</template>

<script>
import MyCounter from '@/components/MyCounter';

export default {
  name: 'app',
  components: {
    DansAwesomeCounter: MyCounter
  }
}
</script>

<style>
h1 {
  text-align: center;
}
</style>
