<!-------------------------------------------------------------->
<!-- Vue Nested Components - App.vue - Lecture Final          -->
<!-------------------------------------------------------------->
<template>
  <div id="app">
    <search-box
      search-url="https://vpic.nhtsa.dot.gov/api/vehicles/getmakeformanufacturer/"
      v-on:search-results="handleResults"> <!-- when the search-results event happens call the method handleResults() -->
    </search-box>  <!-- search-results is a custom event -->
    <results-display v-bind:results="searchResults"></results-display> <!-- api results will be placed in search results -->
  </div>
</template>

<script>
import SearchBox from './components/SearchBox.vue';
import ResultsDisplay from './components/ResultsDisplay.vue';

export default {
  name: 'app',
  components: {
    SearchBox,
    ResultsDisplay
  },
  data() {
    return {
      searchResults: { "Results": [] } // saying our search results is an array
    }
  },
  methods: {
    handleResults(newResults) {
      this.searchResults = newResults;
    }
  }
}
</script>
