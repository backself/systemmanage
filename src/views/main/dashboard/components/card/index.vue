<template>
  <div class="card-list">
    <Row v-for="row in list" :key="row.id" :row="row" />
  </div>
</template>

<script lang="ts">
import { defineComponent,ref } from 'vue'
import {getOnlineData} from "@/api/dashboard/online"
import Row from './row.vue'
export default defineComponent({
  components: {
    Row
  },
  setup() {
	  
    let list = ref([]);
	
	function initOnline(){
		let params = {};
		getOnlineData(params).then(function(res){
			list.value = res.data;
		});
	}
	initOnline();
    return {
      list
    }
  }
})
</script>

<style lang="scss" scoped>
  .card-list {
    width: calc(100% + 20px);
    margin-left: -10px;
    display: flex;
    flex-wrap: wrap;
  }
</style>