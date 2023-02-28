<template>
  <div class="layout-container">
    <div class="layout-container-form flex space-between">
      <div class="layout-container-form-handle">
        <el-button type="primary" :icon="Plus" @click="handleAdd">{{ $t('message.common.add') }}</el-button>
        <el-popconfirm :title="$t('message.common.delTip')" @confirm="handleDel(chooseData)">
          <template #reference>
            <el-button type="danger" :icon="Delete" :disabled="chooseData.length === 0">{{ $t('message.common.delBat') }}</el-button>
          </template>
        </el-popconfirm>
      </div>
      <div class="layout-container-form-search">
        <el-input v-model="query.input" :placeholder="$t('message.common.searchTip')" @change="getTableData(true)"></el-input>
        <el-button type="primary" :icon="Search" class="search-btn" @click="getTableData(true)">{{ $t('message.common.search') }}</el-button>
      </div>
    </div>
    <div class="layout-container-table">
      <Table
        ref="table"
        v-model:page="page"
        v-loading="loading"
        :showSelection="true"
        :data="tableData"
        @getTableData="getTableData"
        @selection-change="handleSelectionChange"
      >
		<el-table-column prop="productId" label="编号" align="center" />
        <el-table-column prop="productName" label="名称" align="center" />
        <el-table-column prop="productRepertories" label="库存" align="center" />
		
		<el-table-column prop="productMatchType" label="匹配模式" align="center">
		  <template #default="scope">
			<el-tooltip :content="scope.row.productMatchType === 1 ? '精准' : '通用'" placement="top">
		    <el-switch
		      v-model="scope.row.productMatchType"
		      active-color="#13ce66"
		      inactive-color="#ff4949"
		      :active-value="1"
		      :inactive-value="0"
		      :loading="scope.row.loading"
			  @change="handleStatusAndMatchType(scope.row)"
		    ></el-switch>
			</el-tooltip>
		  </template>
		</el-table-column>
		
		<el-table-column prop="productStatus" label="产品上线状态" align="center">
		  <template #default="scope">
			<el-tooltip :content="scope.row.productStatus === 1 ? '已上线' : '已下线'" placement="top">
		    <el-switch
		      v-model="scope.row.productStatus"
		      active-color="#13ce66"
		      inactive-color="#ff4949"
		      :active-value="1"
		      :inactive-value="0"
		      :loading="scope.row.loading"
			  @change="handleStatusAndMatchType(scope.row)"
		    ></el-switch>
			</el-tooltip>
		  </template>
		</el-table-column>
		
        <el-table-column :label="$t('message.common.handle')" align="center" fixed="right" width="200">
          <template #default="scope">
            <el-button @click="handleEdit(scope.row)">{{ $t('message.common.update') }}</el-button>
            <el-popconfirm :title="$t('message.common.delTip')" @confirm="handleDel([scope.row])">
              <template #reference>
                <el-button type="danger">{{ $t('message.common.del') }}</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </Table>
      <Layer :layer="layer" @getTableData="getTableData" v-if="layer.show" />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from 'vue'
import Table from '@/components/table/index.vue'
import { Page } from '@/components/table/type'
import { getData, del,update } from '@/api/product/query'
import Layer from './layer.vue'
import { ElMessage } from 'element-plus'
import type { LayerInterface } from '@/components/layer/index.vue'
import { Plus, Search, Delete } from '@element-plus/icons'

export default defineComponent({
  name: 'crudTable',
  components: {
    Table,
    Layer
  },
  setup() {
    // 存储搜索用的数据
    const query = reactive({
      input: ''
    })
    // 弹窗控制器
    const layer: LayerInterface = reactive({
      show: false,
      title: '新增',
      showButton: true
    })
    // 分页参数, 供table使用
    const page: Page = reactive({
      index: 1,
      size: 20,
      total: 0
    })
    const loading = ref(true)
    const tableData = ref([])
    const chooseData = ref([])
    const handleSelectionChange = (val: []) => {
      chooseData.value = val
    }
    // 获取表格数据
    // params <init> Boolean ，默认为false，用于判断是否需要初始化分页
    const getTableData = (init: boolean) => {
      loading.value = true
      if (init) {
        page.index = 1
      }
      let params = {
        page: page.index,
        pageSize: page.size,
        ...query
      }
      getData(params)
      .then(res => {
        let data = res.data.list
        tableData.value = res.data.list
        page.total = Number(res.data.pager.total)
      })
      .catch(error => {
        tableData.value = []
        page.index = 1
        page.total = 0
      })
      .finally(() => {
        loading.value = false
      })
    }
    // 删除功能
    const handleDel = (data: object[]) => {
      let params = {
        ids: data.map((e:any)=> {
          return e.id
        }).join(',')
      }
      del(params)
      .then(res => {
        ElMessage({
          type: 'success',
          message: '删除成功'
        })
        getTableData(tableData.value.length === 1 ? true : false)
      })
    }
    // 新增弹窗功能
    const handleAdd = () => {
      layer.title = '新增数据'
      layer.show = true
      delete layer.row
    }
    // 编辑弹窗功能
    const handleEdit = (row: object) => {
      layer.title = '编辑数据'
      layer.row = row
      layer.show = true
    }
    getTableData(true)
	
	const handleStatusAndMatchType = (row:object) =>{
		console.log(row,'=====')
		let params = row;
		update(params)
		.then(res => {
		  ElMessage({
		    type: 'success',
		    message: '编辑成功'
		  });
		  getTableData(true);
		  
		})
	}
	
    return {
      Plus,
      Search,
      Delete,
      query,
      tableData,
      chooseData,
      loading,
      page,
      layer,
      handleSelectionChange,
      handleAdd,
      handleEdit,
      handleDel,
      getTableData,
	  handleStatusAndMatchType
    }
  }
})
</script>

<style lang="scss" scoped>
  
</style>