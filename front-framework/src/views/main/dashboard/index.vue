<template>
	<div class="box">
		<basic-template />
		<Card :card_item="cardItem" />
		<Charts :chart_data="chartData" />
	</div>
</template>

<script lang="ts">
	import { defineComponent, ref } from 'vue'
	import basicTemplate from './components/basic-template.vue'
	import Card from './components/card/index.vue'
	import Charts from './components/charts/index.vue'
	import { creatWS } from "@/api/dashboard/dashboard"

	export default defineComponent({
		components: {
			Card,
			Charts,
			basicTemplate
		},
		setup() {
			let cardItem = ref({});
			let wsUrl = "ws://127.0.0.1:8003/messages/websocket/1";
			let wsInstance = creatWS(wsUrl);
			let chartData = {};

			wsInstance.onopen = function (evt) {
				console.log("建立连接");
			}
			wsInstance.onmessage = function (evt) {
				
				let msg = JSON.parse(evt.data);
				let displayPosition = parseInt(msg.displayPosition);
				if (displayPosition != 5) { // 只要不是报表信息就修改卡片信息
					let item = {};
					let content = JSON.parse(msg.content);
					item.id = displayPosition;
					item.count = content.count;
					item.type = content.type;
					cardItem.value = item;
				};
					
				if (displayPosition == 5) { // 只要不是报表信息就修改卡片信息
					let item = ref({});
					chartData.value = item.content;
				};
			}


			wsInstance.onclose = function (evt) {
				console.log("断开连接");
			}
			
			return {
				cardItem,
				chartData
			};
		}
	})
</script>

<style lang="scss" scoped>
	.box {
		padding: 15px;
	}
</style>