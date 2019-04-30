<template>
    <div class="search">
        <input type="text" id="search" name="search" placeholder="Search 
Todo's..." v-on:keyup="handleResults" v-model="searchText" />
    </div>
</template>

<script>
export default {
    name: 'shopping-search',
    data() {
        return { 
            searchText: ''
    };
},
methods: { 
    handleResults() {
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