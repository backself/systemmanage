<template>
	<div class="box">
		<Chart :option="option" />
	</div>
</template>

<script lang="ts">
	import { defineComponent, ref,watch } from 'vue'
	import Chart from '@/components/charts/index.vue'
	import { getDashboardBarChartData } from '@/api/dashboard/bar_chart'
	import param from './params'
	import defaultOption from './modules/barchartOption'
	import parseDataToChartOption from './modules/parseDashboardChartData'

	export default defineComponent({
		components: {
			Chart
		}, props: {// 接收由上级组件下发需要同步的属性
			chart_data: {
				type: Array,
				default: []
			}

		},
		setup(props) {
			let option = ref({});
			function initDashboardBarChartsData(param : any) {
				//  getDashboardBarChartData(param).then(function(res:any){
				// option.value = parseDataToChartOption(res.data,defaultOption);
				//  })
			}

			initDashboardBarChartsData(param);
			
			watch(props, (newProps) => {
				console.log("新值：", newProps); //这里看到新值
				option.value = parseDataToChartOption(newProps.chart_data,defaultOption);
			});
				
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