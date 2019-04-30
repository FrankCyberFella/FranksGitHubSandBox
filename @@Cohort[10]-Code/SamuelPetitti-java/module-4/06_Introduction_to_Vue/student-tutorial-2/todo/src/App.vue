<template>
  <div id="todo-app">
    <h2>Hello Java Jazzers</h2>
    <todo-list></todo-list>
  </div>
</template>

<script>
import TodoList from '../Components/TodoList';

export default {
  name: 'app',
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
