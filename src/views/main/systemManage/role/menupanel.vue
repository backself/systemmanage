<template>
  <div class="menu-panel">
    <div class="header-box">
      <h2>对应菜单列表</h2>
    </div>
    <div class="list system-scrollbar">
      <el-tree
        ref="tree"
        class="my-tree"
        :data="data"
        :props="defaultProps"
        :expand-on-click-node="false"
		:show-checkbox="true"
        node-key="urlId"
        highlight-current
        default-expand-all
		:check-strictly="true"
		@check="handleCheckedNodes"
      >
	  </el-tree>
    </div>
	<div class="row el-footer">
		<el-button
		  type="primary"
		  @onclick="saveCurrentCheckedKeysToCurrentCheckedRole"
		  >保存</el-button
		>
	</div>
  </div>
</template>

<script lang="ts">
import type { Ref } from "vue";
import { defineComponent, ref, inject, nextTick } from "vue";
import { getMenuPanelListApi } from "@/api/role";
export default defineComponent({
  setup() {
    let data = ref([]);
    const tree: Ref<any|null> = ref(null)
    const defaultProps = {
      children: "childs",
      label: "urlName",
    };
    const active: any = inject("active");
    const getMenuPanelListData = () => {
      let params = {};
      getMenuPanelListApi(params).then((res) => {
        data.value = res.data;
        nextTick(() => {
			tree.value &&tree.value.setCheckedKeys(active.value.urlList);
        })
      });
    };
    const handleNodeClick = (row: any) => {
      active.value = row;
	  console.log("选中了",row);
    };
	const handleCheckedNodes = (checkedNodes,checkedKeys,halfCheckedNodes,halfCheckedKeys )=>{
		console.log("点击复选框",checkedKeys);
	}
	
	const saveCurrentCheckedKeysToCurrentCheckedRole = function(){
		console.log("保存角色菜单关联关系");
	}
	
    getMenuPanelListData();
    
    return {
      data,
      tree,
      defaultProps,
	  handleCheckedNodes,
	  saveCurrentCheckedKeysToCurrentCheckedRole
    };
  },
});
</script>

<style lang="scss" scoped>
.menu-panel {
  margin-left: 10px;
  background: #fff;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  .header-box {
    padding: 10px;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #eee;
    h2 {
      padding: 0;
      margin: 0;
      margin-right: 20px;
      font-size: 14px;
      display: -webkit-box;
      -webkit-line-clamp: 1;
      -webkit-box-orient: vertical;
      overflow: hidden;
      height: 30px;
      line-height: 30px;
    }
    .el-input {
      flex: 1;
    }
  }
  .list {
    flex: 1;
    overflow: auto;
  }
  .my-tree {
    :deep(.el-tree-node__content) {
      height: 36px;
    }
    :deep(.el-tree-node.is-current>.el-tree-node__content) {
      background-color: rgba(64, 158, 255, 0.4);
    }
    :deep(.el-tree-node>.el-tree-node__content) {
      transition: 0.2s;
    }
  }
}
</style>