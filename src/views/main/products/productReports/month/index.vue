<template>
	
	<div class="layout-container">
	  <div class="layout-container-table">
		<Charts />
	  </div>
	</div>

</template>

<script lang="ts">
import { defineComponent} from 'vue'
import Charts from './components/charts/index.vue'
import { Plus} from '@element-plus/icons'
export default defineComponent({
  components: {
    Charts,
  },
  setup(){
	  return {Plus} 
	},
	
})
</script>

<style lang="scss" scoped>
  .layout-container {
	  width:100%;
	  height:100%;
	  padding:0px;
  }
</style>