<template>
  <div class="box">
    <Chart :option="option" />
  </div>
</template>

<script lang="ts">
import { defineComponent,ref } from 'vue'
import Chart from '@/components/charts/index.vue'
import { creatWS, getDashboardBarChartData } from '@/api/dashboard/bar_chart'
import param from './params'
import defaultOption from './modules/barchartOption'
import parseDataToChartOption from './modules/parseDashboardChartData'

export default defineComponent({
  components: {
    Chart
  },
  setup() {
	  
	  let wsUrl = "";
	  let wsInstance = creatWS(wsUrl);
	  wsInstance.onopen = function(evt){
		  console.log("Connection is opening ..."); 
	  }
	  wsInstance.onmessage  = function(evt){
			console.log("Connection is recive ...",evt.data); 
	  }
	  wsInstance.onclose = function(evt){
	  		  console.log("Connection is close ..."); 
	  }
	  let option = ref({});
	  function initDashboardBarChartsData(param:any){
		  getDashboardBarChartData(param).then(function(res:any){
			option.value = parseDataToChartOption(res.data,defaultOption);
		  })
	  }
	  
	  initDashboardBarChartsData(param);
	  
    return {
      option,
	  initDashboardBarChartsData
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