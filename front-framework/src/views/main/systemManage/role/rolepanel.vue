<template>
  <div class="category">
    <div class="header-box">
      <h2>角色列表</h2>
    </div>
    <div class="list system-scrollbar">
      <el-tree
        ref="tree"
        class="my-tree"
        :data="data"
        :props="defaultProps"
        :expand-on-click-node="false"
        node-key="roleId"
        highlight-current
        default-expand-all
        @node-click="handleNodeClick"
      ></el-tree>
    </div>
  </div>
</template>

<script lang="ts">
import type { Ref } from "vue";
import { defineComponent, ref, inject, nextTick } from "vue";
import { getRolePanelListApi } from "@/api/systemManagers/role";;
export default defineComponent({
  setup() {
    let data = ref([]);
    const tree: Ref<any|null> = ref(null)
    const defaultProps = {
      children: "childs",
      label: "roleName",
    };
    const active: any = inject("active");
    const getRolePanelListData = () => {
      let params = {};
      getRolePanelListApi(params).then((res) => {
        data.value = res.data;
        active.value = res.data[0];
        nextTick(() => {
          tree.value && tree.value.setCurrentKey(active.value.roleId)
        })
      });
    };
    const handleNodeClick = (row: any) => {
      active.value = row;
    };
	
    getRolePanelListData();
    
    return {
      data,
      tree,
      defaultProps,
      handleNodeClick
    };
  },
});
</script>

<style lang="scss" scoped>
.category {
	margin-right: 10px;
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