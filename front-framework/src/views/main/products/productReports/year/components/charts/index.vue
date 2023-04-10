<template>
  <div>
	<el-row :gutter="20">
	  	<div class="layout-container-form-handle">
	  	  <el-button
	  	    type="primary"
	  	    :icon="Download"
	  	    class="export-excel-btn"
	  	    @click="handleExportExcel"
	  	    >{{ $t('message.common.exportExcel') }}</el-button
	  	  >
	  	</div>
	</el-row>
	
		<barChart :downloadFileParamsForBarChart="sendDownloadFileParamsForBarChart" 
		@update:barChartComponentParams="updateDownloadParams"/>
		
    <el-row :gutter="20">
		
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent,reactive,unref } from 'vue'
import barChart from './barChart.vue'
import { ElMessage } from 'element-plus'
import { aoaToSheetXlsx } from '@/utils/file/ExportExcel'
import { Download } from '@element-plus/icons'
import REPORT_TYPE from '@/views/main/products/productReports/commons/enum'
import moment from 'moment'

export default defineComponent({
  components: {
    barChart,
  },
  setup() {
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
	  
	  //下载请求的参数配置，需要charts中barChart组件将此参数修改后同步到当前组件
	  let sendDownloadFileParamsForBarChart = reactive(params);
	  
	  const handleExportExcel = () => {
	  	ElMessage({
	  		type: 'success',
	  	    message: '导出成功'});
	  
	    let table = unref([{
	  	  id:"1",
	  	  name:"aa",
	  	  radio:'离线'
	    }])
	    let header = ['ID', '姓名', '在线状态']
	    let data = table.map((item) => {
	      let { id, name, radio } = item
	      return [id, name, radio]
	    })
	    aoaToSheetXlsx({
	      data,
	      header,
	      filename: `${unref('新文件')}.xlsx`,
	    })
	  }
	  const handleExportZip = () => {}
	  
	  return {
		  Download,
		  handleExportExcel,
		  handleExportZip,
		  sendDownloadFileParamsForBarChart // 将sendDownloadFileParamsForBarChart
											// 作为props属性传递出去
		  }
  },
  methods:{
	  updateDownloadParams(params:object){
		  //当一个对象作为props属性传递时，修改其值需要修改属性值来修改整个对象的值，不能用'='来直接赋值
		  this.sendDownloadFileParamsForBarChart.startTime = params.startTime;
		  this.sendDownloadFileParamsForBarChart.endTime = params.endTime;
		  this.sendDownloadFileParamsForBarChart.type = params.type;
		  console.log("当前父组件的参数",this.sendDownloadFileParamsForBarChart);
	  }
  }
  
})
</script>

<style lang="scss" scoped>
  
</style>