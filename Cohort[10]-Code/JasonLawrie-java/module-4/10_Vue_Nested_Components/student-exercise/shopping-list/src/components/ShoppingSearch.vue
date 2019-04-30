<template>
    <div class="search">
        <input v-on:keyup="updateSearch" v-model="search" type="text" id="search" name="search" placeholder="Search Todo's..."/>
    </div>
</template>

<script>
export default {
    data(){
        return{
            search:''
        }
    },
    methods: {
        updateSearch(){
            this.$emit('search',this.search);
        }
    }
}
</script>

<style>
#search {
    width:100%;
    font-size:24px;
    font-family: 'Roboto Condensed', sans-serif;
    padding:10px;
}
</style>