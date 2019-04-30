<template>
    <input type="text" name="filter" id="filter" placeholder="Filter Users" v-model="filter" v-on:input="filterChange"/>
</template>

<script>
export default {
    name: 'user-filter',
    data() {
        return {
            filter: ''
        }
    },
    methods: {
        filterChange() {
            this.$emit('new-filter', this.filter);
        }
    }
}
</script>
