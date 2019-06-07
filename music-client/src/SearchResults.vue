<template>
  <table v-if="results.length > 0" class="table table-inbox table-hover table-striped">
    <thead>
    <tr><th>Artist Name</th><th>Album Title</th></tr>
    </thead>
    <tbody>
    <tr v-for="result in results">
      <td>{{ result.artistName }}</td>
      <td>
        <a target="_blank" :href="result.collectionViewUrl">{{ result.collectionName }}</a>
      </td>
    </tr>
    </tbody>
  </table>

  <p v-else> </p>
</template>

<script>
  export default {
    props: {
      results: {
        type: Array,
        required: true
      }
    }
  }
</script>
