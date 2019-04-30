<template>
    <div class="search">
        <input type="text" id="search" name="search" placeholder="Search
        Todo's..." v-model="search" v-on:keyup="handleFilter"/>
    </div>
</template>

<script>

export default {
name: 'shopping-search',
data() {
        return {
            /**
             * Bound to the search input field
             * @property {string} search the user's search query
             */
            search: ''
        };
    },
methods: {
    handleFilter() {
            this.$emit('filter', this.search);
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
