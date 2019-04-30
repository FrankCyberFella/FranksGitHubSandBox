<template>
    <input type="text" name="filter" id="filter" placeholder="Filter Users" v-model="filter" v-on:input="filterChange"/>
</template>

<style>
@import url( 'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' ); 
</style>

<script>
import userStore from '@/stores/user';
export default {

    name: 'user-filter',
    data() {
        return {
            filter: ''
        }
    },
    methods: {
        filterChange() {
            userStore.commit('changeFilter', this.filter);
        }
    }
}
</script>
