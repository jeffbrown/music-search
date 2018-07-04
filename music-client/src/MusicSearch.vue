<template>
  <aside class="lg-side">
    <h1>iTunes Music Search</h1>

    <hr>

    <form @submit.prevent="submitSearch">
      <div class="form-group">
        <input placeholder="Enter Band Name" type="text" class="form-control" id="search-criteria"
               v-model="searchCriteria">
      </div>
      <input type="submit" class="btn btn-primary" value="Search">
    </form>

    <search-results :results="results"></search-results>
  </aside>
</template>

<script>
  import SearchResults from './SearchResults'

  export default {
    data() {
      return {
        searchCriteria: '',
        results: []
      };
    },
    methods: {
      submitSearch() {
        this.$http.get('music/search/{searchCriteria}', {
          params: {
            searchCriteria: this.searchCriteria
          }
        })
          .then(
            response => {
              return response.json();
            },
            response => {
              alert('Error');
            }
          ).then(searchResults => this.results = searchResults);
      }
    },
    components: {
      searchResults: SearchResults
    }
  }
</script>
