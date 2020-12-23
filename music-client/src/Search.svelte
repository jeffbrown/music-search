<script>
    import SearchResults from './SearchResults.svelte'
    import axios from 'axios';

    let searchResults = [];
    let maxResults = 10;
    let searchCriteria = '';

    async function search() {
        const resp = await axios.get(`https://music-search.micronaut.io/music/search/${searchCriteria}`, {
            params: {
                maxResults: maxResults
            }
        })
        searchResults = resp.data;
    }
</script>

<div class="form-group">
    <input size="15" placeholder="Enter Band Name" type="text" class="form-control" id="search-criteria" bind:value={searchCriteria}>
</div>
<div class="form-group">
    <label>Maximum Number Of Results: </label>
    <label>
        <input type=radio bind:group={maxResults} value={5}>
        5
    </label>

    <label>
        <input type=radio bind:group={maxResults} value={10}>
        10
    </label>

    <label>
        <input type=radio bind:group={maxResults} value={25}>
        25
    </label>
</div>
<div class="form-group">
    <button class="btn btn-primary" disabled={!searchCriteria} on:click={search}>Search</button>
</div>

<SearchResults {searchResults}/>