/**
 * 获取数据中的图例名称
 */
export function getLegendNames(responseData){
	let names = [];
	responseData.forEach((item)=>{
		names.push(item.name);
	});
	return names;
}
/**
 * 获取x轴
 * 获取数据列表中data属性中长度最长的元素，
 * 并将该数组中的对象中的time属性提取出来作为x轴
 */
export function getXAxisNames(responseData){
	let xAxisNames = [];
	let maxArray = [];
	responseData.forEach((item)=>{
		if(item.data.length > maxArray.length){
			maxArray = item.data;
		}
	});
	
	maxArray.forEach((obj)=>{
		xAxisNames.push(obj.time);
	})
	return xAxisNames;
}
/**
 * 将list列表中的每个元素中用于展示的数据都提取出来
 */
export function getXAxisData(responseData){
	let xAxisData = [];
	responseData.forEach((item)=>{
		let temp = [];
		item.data.forEach((obj)=>{
			temp.push(obj.data);
		});
		xAxisData.push(temp);
	});
	return xAxisData;
}