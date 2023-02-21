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
		<barChart/>
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

export default defineComponent({
  components: {
    barChart,
  },
  setup() {
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
	}
  }
})
</script>

<style lang="scss" scoped>
  
</style>