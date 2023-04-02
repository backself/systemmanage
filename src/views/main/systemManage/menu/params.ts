// 获取链接列表请求参数
let list_param = {}
// 新增，修改，删除 链接的请求参数
let url_form = {
	urlId:"",
	urlName:"",
	urlType:"",
	urlLink:"",
	urlStatus:"",
	urlCommonLevel:"",
	urlMatchType:"",
	urlSpecLevel:""
}
let url_del = {
	urlIds:[],
	
}
export {list_param,url_form,url_del};