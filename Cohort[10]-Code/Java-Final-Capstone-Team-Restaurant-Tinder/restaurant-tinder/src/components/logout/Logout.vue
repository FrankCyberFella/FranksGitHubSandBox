<template>
    <div id="weDidIt">
                <button class="btn btn-primary" id="logout" type='button' v-on:click="logMeOut">Logout</button>
    </div>
</template>

<script>
export default {

 methods: {
     logMeOut() {
            console.log("This is actually working");
            localStorage.removeItem('Authorization');
            this.$router.push({ path: '/login'});
        }
}}
</script>

<style>
#weDidIt {
    display: inline-block;
    width: 100%;
    
  }
  #logout {
      float: right;
      margin-right: 5%;
  }
</style>
