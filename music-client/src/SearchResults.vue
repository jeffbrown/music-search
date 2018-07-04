<template>
  <table v-if="results.length > 0" class="table table-inbox table-hover">
    <thead>
    <tr><td>Artist Name</td><td>Album Title</td></tr>
    </thead>
    <tbody>
    <tr v-for="result in results">
      <td>{{ result.artistName }}</td>
      <td>{{ result.collectionName }}</td>
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
