<template>
  <div class="layout-container">
	  
	  <div class="layout-container-form-handle" style="margin-bottom: 10px;">
	    <el-button type="primary" :icon="Plus" @click="handleAdd">{{ $t('message.common.add') }}</el-button>
		<el-button @click="handleEdit">{{ $t('message.common.update') }}</el-button>
		<el-popconfirm :title="$t('message.common.delTip')" @confirm="handleDel">
		  <template #reference>
		    <el-button type="danger" :icon="Delete">{{ $t('message.common.del') }}</el-button>
		  </template>
		</el-popconfirm>
	  </div>
	  
    <div class="box">
      <el-tree
        ref="tree"
        class="my-tree"
        :data="treeData"
        :props="defaultProps"
		:check-strictly=true
        node-key="id"
        highlight-current
        default-expand-all
		:show-checkbox="true"
      >
        <template #default="{ node, data }">
          <div class="custom-tree-node" @click="show(node, data)">
            <span v-if="data.urlName">{{ $t(data.urlName) }}</span>
          </div>
        </template>
      </el-tree>
    </div>
  </div>
  <Layer :layer="layer" @updateLinkListData="initLinkListData" v-if="layer.show" />
</template>

<script lang="ts">
import type {Ref} from "vue"
import { defineComponent ,ref,reactive} from "vue";
import { useRouter } from "vue-router";
import Layer from './layer.vue'
import { Plus, Delete } from '@element-plus/icons'
import {ElMessage}from "element-plus"
import {getLinkListData,del} from "@/api/systemManagers/menu"

import axios from 'axios'

import {list_param,url_del} from "./params"

export default defineComponent({
	components: {
	  Layer
	},
  setup() {
	const tree: Ref<any|null> = ref(null);
    const defaultProps = {
      children: "childs",
      label: "urlName",
    };
    const router = useRouter();
    console.log(router);
    const routes = router.options.routes;
    console.log(routes);
    const show = (node: any, data: any) => {
      console.log("标题",node.data);
      console.log(data);
    };
	const treeData = ref([]);
	const layer = reactive({
	  show: false,
	  title: '新增',
	  showButton: true
	})
	const loading = ref(true)
	// 获取表格数据
	// params <init> Boolean ，默认为false，用于判断是否需要初始化分页
	const initLinkListData = () => {
	  loading.value = true
	  let params = list_param;
	  getLinkListData(params).then(function(res){
		  treeData.value = res.data;
		  console.log(treeData);
	  });
	}
	
	const handleEdit = function(){
	
		if(tree.value.getCheckedKeys().length == 1){
			layer.title = '编辑数据';
			layer.show = true;
			layer.url = tree.value.getCheckedNodes()[0];
		}else{
			ElMessage({
				type:"warning",
				message: '只能选择一个菜单进行编辑'
			});
		}
	}
	const handleAdd = function(){
		layer.title = '新增数据';
		layer.show = true;
		layer.url = {};
	}
	const handleDel = function(){
		let params = url_del;
		params.urlIds = tree.value.getCheckedKeys();
		del(params).then(function(res){
			ElMessage({
				type:"success",
				message: '删除成功'
			});
			location.reload();
		});
	}
	initLinkListData();
	
    return {
		tree,
		treeData,
      routes,
      defaultProps,
      show,
	  loading,
	  layer,
	  handleEdit,
	  handleAdd,
	  handleDel,
	  Plus, 
	  Delete,
	  initLinkListData
    };
  },
});
</script>

<style lang="scss" scoped>
.layout-container {
  padding: 15px;
  box-sizing: border-box;
}
.box {
  border: 1px solid #eee;
  overflow-y: auto;
  height: calc(100%);
}
.my-tree {
  :deep(.el-tree-node__content) {
    height: 36px;
  }
  :deep(.el-tree-node.is-current > .el-tree-node__content) {
    // background-color: rgba(64, 158, 255, 0.4);
  }
  :deep(.el-tree-node > .el-tree-node__content) {
    transition: 0.2s;
  }
}
</style>