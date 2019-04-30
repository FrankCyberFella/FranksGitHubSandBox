<template>
    <div class="search"> 
        <input type="text" id="search" name="search" placeholder="Search Todo's..." v-model="searchTodos" v-on:keyup="handleFilter" />
    </div>    
 

</template>

<script>
export default {
    name: 'shopping-search',
    data() {
        return {
            searchTodos: ''
        };
    },
    methods: {
        handleFilter() {
            this.$emit('filter', this.searchTodos);
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
