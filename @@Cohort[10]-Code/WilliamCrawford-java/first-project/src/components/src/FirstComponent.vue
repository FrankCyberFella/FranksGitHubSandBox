<template>
import { Script } from 'vm';
    <div> 
        <h1>{{message}}</h1>
    </div>
</template>
<style scoped>
    h1 {
        color: blue;
        
    }
</style>

<script>
export default {
    name: 'first-component',
    data() {
        return {
            message: 'Our message from first component'
        }
    }
}
</Script>