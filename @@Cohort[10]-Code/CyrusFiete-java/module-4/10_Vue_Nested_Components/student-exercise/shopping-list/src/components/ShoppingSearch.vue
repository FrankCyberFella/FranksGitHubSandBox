<template>
    <div class="search">
        <input type="text" id="search" name="search" placeholder="Search Lists..." v-on:keyup="handleFilter" v-model="searchText"/>
    </div>
</template>

<script>
export default {
    name: 'shopping-search',
    data() {
        return {
            searchText: ''
        }
    },
    methods: {
        handleFilter() {
            this.$emit('filter', this.searchText);
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