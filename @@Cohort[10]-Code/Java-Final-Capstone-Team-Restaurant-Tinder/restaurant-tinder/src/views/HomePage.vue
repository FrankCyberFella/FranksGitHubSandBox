<template>
    <div id="home-page">
        <restaurant-choice></restaurant-choice>
        
        <navbar></navbar>
    </div>
</template>

<script>

import RestaurantChoice from '@/components/homepage/RestaurantChoice.vue'
import Navbar from '@/components/nav/NavBar.vue'

export default {
    name: 'home-page',
    components: {
        RestaurantChoice,
        Navbar
    }
}

</script>

<style>



</style>
