<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>尊敬的xxx用户</span>
      </div>
    </template>
      <div class="box">
        <div class="item">
          <p>您好</p>
        </div>

      </div>
  </el-card>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {

  }
})
</script>

<style lang="scss" scoped>
  .box-card {
    .card-header{
      text-align: left;
    }
    .box {
      .item {
        display: flex;
        align-items: center;
        * {
          margin-right: 20px;
        }
      }
    }
  }
</style>