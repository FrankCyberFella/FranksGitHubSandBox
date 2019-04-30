<template>
     <div>
    <h1>{{message}}</h1>
    <p>{{main}}</p>
    <label for = "firstName">Enter First Name </label>
    <input v-if="inputShow" v-model="firstName" placeholder="firstname"/>
    <p>{{ firstName }}</p>
    <button type="submit" v-on:submit="showInput">Show Input</button>
    </div>
</template>

<script>
export default {
    data(){
        return {
            message: "Hi Sam!",
            main: "This is me, I, Samuel Peters checking out how to use this damn thing.",
            firstName:'',
            inputShow: true

        }
    },
    methods: {
          showInput(vm) {
            vm.inputShow = !vm.inputShow;
        }
    }

}
</script>

<style>

</style>
