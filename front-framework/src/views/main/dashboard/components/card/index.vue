<template>
	<div class="card-list">
		<Row v-for="row in list" :key="row.id" :row="row" />
	</div>
</template>

<script lang="ts">
	import { defineComponent, ref, watch } from 'vue'
	import Row from './row.vue'
	import defaultData from './modules/defaultData'

	export default defineComponent({
		components: {
			Row
		},
		props: {// 接收由上级组件下发需要同步的属性
			card_item: {
				type: Object,
				default: {
					"id": Number, // 数据位置
					"count": Number, // 数据内容
					"type": Number // 修改方式
				}
			}

		},
		setup(props) {

			let list = ref([]);
			list.value = defaultData;

			watch(props, (newProps) => {
				console.log("新值：", newProps); //这里看到新值
				let item = newProps.card_item;
				let index = parseInt(item.id) - 1;
				let dist = list.value[index];
				console.log(dist.data);
				if (item.type == 1) { // 等于1 做加法
					console.log(dist);
					dist.data = dist.data + item.count;
				}
				if (item.type == 0) { // 等于0 做减法
					dist.data = (dist.data - item.count) > 0 ?
						(dist.data - item.count) : 0;
				}

			});
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