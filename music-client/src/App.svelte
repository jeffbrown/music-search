<script>
  import { onMount } from 'svelte';
  const GITHUB_REPO_URL = 'https://github.com/jeffbrown/music-search/commit/';
  const MAX_RESULTS = [5, 10, 25];
  const URL_PREFIX = __myapp.env.isProd ? '' :
          'http://localhost:8080';

  let bandName = '';
  let albums = [];
  let error = '';
  let maxResults = MAX_RESULTS[0];
  let buildInfo = {};

  async function search() {
    const url = URL_PREFIX + '/music/search/' + bandName + '?maxResults=' + maxResults;
    try {
      const res = await fetch(url);
      if (!res.ok) throw new Error(await res.text());
      albums = await res.json();
    } catch (e) {
      error = e;
    }
  }

  onMount(async () => {
    const url = URL_PREFIX + '/info';
    try {
      const res = await fetch(url);
      if (!res.ok) throw new Error(await res.text());
      buildInfo = await res.json();
    } catch (e) {
      error = e;
    }
  })
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
  <div class="footer">
  {#if buildInfo.git}
    <span>Version {buildInfo.build.version} Built At {buildInfo.build.time} (<a href="{GITHUB_REPO_URL}{buildInfo.git.commit.id}">{buildInfo.git.commit.id.substring(0, 10)}</a>)</span>
  {/if}
  </div>
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
