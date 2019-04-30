<template>
  <div id="todo-app">
    <h2 style="text-align: center;">Hello Java Nation</h2>
    <todo-list></todo-list> 
    <!-- custom html tag created  <todo-list> -->
  </div>
</template>

<script>
import TodoList from './components/TodoList';

export default {
  name: 'app', //assign this name to whatever is in components
  components: {
    TodoList
  }
}
</script>

<style>
body {
background: rgb(74,162,244);
background: radial-gradient(circle, rgba(74,162,244,1) 0%, rgba(54,131,240,1) 100%);}
</style>
