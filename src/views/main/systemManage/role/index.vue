<template>
  <div class="full">
    <div class="left">
      <role-panel />
    </div>
    <div class="content">
      <menu-panel />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, provide } from 'vue'
import RolePanel from './rolepanel.vue'
import MenuPanel from './menupanel.vue'
export default defineComponent({
  name: 'treeTable',
  components: {
	  RolePanel,
    MenuPanel,
  },
  
  setup() {
    let active: any = ref({})
    provide('active', active)
  }
})
</script>

<style lang="scss" scoped>
  .full {
    width: 100%;
    height: 100%;
    box-sizing: border-box;
    padding: 15px;
    display: flex;
    .left {
      width: 250px;
    }
    .content {
      flex: 1;
      width: calc(100% - 250px);
      height: 100%;
    }
  }
</style>