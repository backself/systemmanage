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
import { defineComponent,ref} from 'vue'
import Chart from '@/components/charts/index.vue'
import {setOption} from '@/views/main/products/productReports/commons/barTemplate'
import REPORT_TYPE from '@/views/main/products/productReports/commons/enum'
import {getData} from '@/api/product/report'
import moment from "moment"
export default defineComponent({
	components: {
	  Chart
	},
	props:{// 接收由上级组件下发需要同步的属性
		downloadFileParamsForBarChart:{ // 声明下发的props中params的类型和默认值
			type:Object,
			default:()=>{
				return {
					type:REPORT_TYPE.YEAR_REPORT,
					startTime:"",
					entTime:"",
					productId:1,
					userId:1
				  }
			}
		}
	},
	setup(props) {
		let params = props.downloadFileParamsForBarChart;
		const option =ref({});
		// 初始化图表数据
		function init(params:object){
			getData(params).then(function(res){
				option.value = setOption(res.data);
			})
		}
		
		init(params);
	  return {
	    option,
	  }
	},
	methods:{
		//修改传递给父级组件的参数
		changeParamsToDownloadFile(){
			let startTime = new Date();
			startTime.setMonth(0);
			startTime.setDate(1);
			startTime.setHours(7);
			startTime.setMinutes(0);
			startTime.setSeconds(0);
			startTime.setMilliseconds(0);
			let entTime = new Date( startTime);
			entTime.setFullYear(startTime.getFullYear()-1);
			
			console.log("今天",moment(startTime).format("YYYY-MM-DD hh:mm:ss.S"));
			console.log("昨天",moment(entTime).format("YYYY-MM-DD hh:mm:ss.S"));
			
			let params = {
				type:REPORT_TYPE.YEAR_REPORT,
				startTime:startTime,
				entTime:entTime,
				productId:1,
				userId:1
			}
			this.props = {downloadFileParamsForBarChart:params};
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