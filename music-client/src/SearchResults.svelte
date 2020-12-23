<script>
    export let searchResults = [];
</script>

<table>
    {#each searchResults as {artistName, collectionName, collectionViewUrl}}
        <tr>
            <td>{artistName}</td>
            <td><a target="_blank" href={collectionViewUrl}>{collectionName}</a></td>
        </tr>
    {/each}
</table>