<template>
  <div class="counter">
     <button id="counter" v-on:click="increase">Increment</button>
     <!-- <button id="decrementer" v-on:click="decrease">Decrement</button>
     <button id="crazy" v-on:click="crazy">Crazy</button> -->
     <p>current count is: {{count}} </p>
  </div>
</template>

<script>
export default {
    name: 'my-counter',
    data(){
        return {
            count: 0
        }
    },
    methods: {
        increase(){
            this.count += 1;
        }
        // decrease(){
        //     this.count -= 1;
        // },
        // crazy(){
        //     this.count += Math.floor(Math.random() * 1000000);
        // }
    }
}
</script>

<style>

</style>
