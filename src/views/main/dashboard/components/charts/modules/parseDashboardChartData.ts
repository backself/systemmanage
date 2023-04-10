import {getLegendNames, getXAxisNames, getXAxisData} from '@/utils/charts/parseDataToChartsFunctions'

/**
 * 将responseData数据转换为 chart可用的option
 * @param {Object} responseData
 * @param {Object} option
 */
export default function parseDataToChartOption(responseData,option){
	option.legend.data = getLegendNames(responseData);
	option.xAxis.data = getXAxisNames(responseData);
	// 第一个柱状的数据
	option.series[0].name = getLegendNames(responseData)[0];
	option.series[0].data = getXAxisData(responseData)[0];
	option.series[0].itemStyle.color = responseData[0].color;
	// 第二个柱状的数据
	option.series[1].name = getLegendNames(responseData)[1];
	option.series[1].data = getXAxisData(responseData)[1];
	option.series[1].itemStyle.color = responseData[1].color;
	// 第一个折线的数据
	option.series[2].name = getLegendNames(responseData)[2];
	option.series[2].data = getXAxisData(responseData)[2];
	option.series[2].color = responseData[2].color;
	return option;
}