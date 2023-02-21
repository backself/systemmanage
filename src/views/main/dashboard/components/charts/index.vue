<template>
  <div>
    <barChart />
    <el-row :gutter="20">
		
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import barChart from './barChart.vue'
export default defineComponent({
  components: {
    barChart,
  },
  setup() {

  }
})
</script>

<style lang="scss" scoped>
  
</style>