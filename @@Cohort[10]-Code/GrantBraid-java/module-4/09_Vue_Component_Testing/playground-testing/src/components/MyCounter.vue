<template>
    <div class="count">
        <div class="counter">
            <button id="inc" v-on:click="increase">Increment</button>
            <button id="dec" v-on:click="decrease">Decrease</button>
        </div>
        <p>Your current count: {{count}}</p>
   
    </div>
</template>

<script>
export default {
    name: 'my-counter',
    data() {
        return {
            count: 0
        }
    },
    methods: {
        increase() {
            this.count += 1;
        },
        decrease() {
            this.count -= 1;
        }
    }
};
// ul>li*5
</script>

<style>
.counter {
    display: flex;
    flex-direction: row-reverse;
    justify-content: center;
}
button {
    font-size: 200%;
    margin-right: 10px;
    margin-top: 20px;

}
p {
    text-align: center;
    font-size: 150%;
}
</style>
