<template>
    <div id="counter">
        <button id="decrement" v-on:click="decrease">Decrement</button>
        <button id="increment" v-on:click="increase">Increment</button>
        <p>Current Count is: {{count}}</p>
    </div>
</template>

<script>
export default {
    name: 'my-counter',
    data(){
        return{
            count: 0
        }
    },
    methods:{
        increase() {
            this.count += 1;
        },
        decrease(){
            this.count --;
        }
    }

}
</script>

<style>
    p{
        color: white;
        text-shadow: 0px 0px 5px #666;
    }
    body{
        background: #333;
    }
    button{
        font-size: 30px;
        color: #333;
        font-weight: bold;
        text-shadow: 0px 0px 20px white;
        background: red;
        width: 500px;
        height: 300px;
        padding: 10px;
        margin: 10px;
        border-style: none;
        border-radius: 50%;
        box-shadow: 0px 0px 30px black;
        
    }
    button:focus {
        outline:0;
        }

    button:hover{
        background: maroon;
    }
</style>
