<template>
  <aside class="lg-side">
    <h1>iTunes Music Search</h1>

    <hr>

    <form @submit.prevent="submitSearch">
      <div class="form-group">
        <input placeholder="Enter Band Name" type="text" class="form-control" id="search-criteria"
               v-model="searchCriteria">
      </div>

      <div class="form-group">
        <label>Maximum Number Of Results:</label>
        <label class="radio-inline">
          <input type="radio" value="5" v-model="maxResults" name="maxResults">5
        </label>
        <label class="radio-inline">
          <input type="radio" value="10" v-model="maxResults" name="maxResults">10
        </label>
        <label class="radio-inline">
          <input type="radio" value="25" v-model="maxResults" name="maxResults">25
        </label>
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
        maxResults: 25,
        results: []
      };
    },
    methods: {
      submitSearch() {
        this.$http.get('music/search/{searchCriteria}', {
          params: {
            searchCriteria: this.searchCriteria,
            maxResults: this.maxResults
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
