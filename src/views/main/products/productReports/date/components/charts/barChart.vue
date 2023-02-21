<template>
  <div class="box">
    <Chart :option="option" />
  </div>
  <el-button
    type="primary"
    class="export-excel-btn"
    @click="changeParamsToDownloadFile()"
    sytle="display:hidden">emit--->{{downloadFileParamsForBarChart}}</el-button
  >
</template>

<script lang="ts">
import { defineComponent} from 'vue'
import Chart from '@/components/charts/index.vue'
import option from './modules/bar'
export default defineComponent({
	components: {
	  Chart
	},
	props:{// 接收由上级组件下发需要同步的属性
		downloadFileParamsForBarChart:{ // 声明下发的props中params的类型和默认值
			type:Object,
			default:()=>{
				return {
					p1:'默认值',
					p2:'默认参值',
				}
			}
		}
	},
	setup(props) {
		
	  return {
	    option,
	  }
	},
	methods:{
		changeParamsToDownloadFile(){
			let tmp = {downloadFileParamsForBarChart:{
									p1:Math.random(10),
									p2:"de",
								},
						}
			this.props = tmp;
			console.log("子组件传递到父组件的参数",this.props.downloadFileParamsForBarChart);
			this.$emit('update:barChartComponentParams',this.props.downloadFileParamsForBarChart); 
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