<template>
    <div class="search">
        <input  type="text" v-model="searchText" id="search" name="search" @keyup="filterItems" placeholder="Search Todo's..."/>
    </div>
</template>

<script>
export default {
   
    methods: {
        filterItems(){
            const query= document.getElementById('search').value;
            this.$emit('filter-items', query);
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