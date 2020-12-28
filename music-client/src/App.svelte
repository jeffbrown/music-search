<script>
  const MAX_RESULTS = [5, 10, 25];
  const URL_PREFIX = __myapp.env.isProd ? 'https://music-search.micronaut.io/music/search/' :
          'http://localhost:8080/music/search/';

  let bandName = '';
  let albums = [];
  let error = '';
  let maxResults = MAX_RESULTS[0];

  async function search() {
    const url = URL_PREFIX + bandName + '?maxResults=' + maxResults;
    const res = await fetch(url);
    if (res.ok) {
      albums = await res.json();
    } else {
      error = await res.text();
    }
  }
</script>

<main>
  <h1>iTunes Music Search</h1>
  <form on:submit|preventDefault>
    <input placeholder="Enter Band Name" type="text" bind:value={bandName} />
    <div class="max-results">
      Maximum Number Of Results:
      {#each MAX_RESULTS as max}
        <input
          id="max-results"
          type="radio"
          value={max}
          bind:group={maxResults} />
        {max}
      {/each}
    </div>
    <button disabled={bandName === ''} on:click={search}>Search</button>
  </form>
  {#if error}
    <div class="error">{error}</div>
  {:else if albums.length}
    <table>
      <tr>
        <th>Artist Name</th>
        <th>Album Title</th>
      </tr>
      {#each albums as album}
        <tr>
          <td>{album.artistName}</td>
          <td>
            <a
              href={album.collectionViewUrl}
              target="_blank">{album.collectionName}</a>
          </td>
        </tr>
      {/each}
    </table>
  {/if}
</main>

<style>
  main {
    margin: 0 2rem;
    width: 530px;
  }

  .max-results {
    display: flex;
    margin-bottom: 1rem;
  }
</style>
