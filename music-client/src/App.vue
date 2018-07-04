<template>
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <music-search></music-search>
      </div>
    </div>
  </div>
</template>

<script>
  import MusicSearch from './MusicSearch.vue';
  export default {
    components: {
      musicSearch: MusicSearch
    }
  }
</script>

<style>
</style>
