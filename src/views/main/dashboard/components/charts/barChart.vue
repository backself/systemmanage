<template>
  <div class="box">
    <Chart :option="option" />
  </div>
</template>

<script lang="ts">
import { defineComponent,ref } from 'vue'
import Chart from '@/components/charts/index.vue'
import { getData } from '@/api/dashboard/bar_chart'
export default defineComponent({
  components: {
    Chart
  },
  setup() {
	  let params = {};
	  let option = ref({});
	  function initCTableData(params:any){
		  getData(params).then(function(res:any){
		  		  option.value = res.data;
		  })
	  }
	  initCTableData(params);
	  
    return {
      option,
	  initCTableData
    }
  }
})
</script>

<style lang="scss" scoped>
  .box {
    margin: 10px auto 0;
    width: calc(100% - 40px);
    height: 400px;
    background: var(--system-page-background);
    padding: 20px;
    overflow: hidden;
  }
</style>