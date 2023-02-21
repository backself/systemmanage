<template>
  <div class="box">
    <basic-template />
    <Charts />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import Charts from './components/charts/index.vue'
export default defineComponent({
  components: {
    Charts
  }
})
</script>

<style lang="scss" scoped>
  .box {
    padding: 15px;
  }
</style>