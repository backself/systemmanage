import { createNameComponent } from './createNode'

/**
 * 将data中的菜单数据结构转换为路由结构
 */
export function parseDataToRouter(data : any, type : number) {
	let res = [];
	data.forEach(item => {
		let tempData = {
			path: "",
			component: "",
			meta: {},
		};
		
		let routConfig = JSON.parse(item.urlLink);
		let routChildren = item.childs;

		tempData.path = routConfig.path;
		tempData.meta = routConfig.meta;

		if (routChildren && routChildren.length > 0) {
			if (type === 0) {
				// 一级菜单组件
				tempData.component = createNameComponent(() => import('../layout/' + routConfig.componentPath + '.vue'))
			} else {
				// 二级及其他级别组件
				tempData.component = createNameComponent(() => import('../components/menu/' + routConfig.componentPath + '.vue'))
			}
			tempData.children = parseDataToRouter(routChildren, type + 1)
		} else {
			// 叶子组件的导入
			// d.component = createNameComponent(() => import('@/views/main/products/productManage/query/index.vue'))
			tempData.component = createNameComponent(() => import('../views/' + routConfig.componentPath + '.vue'))
		}

		if (routConfig.redirect) {
			tempData.redirect = routConfig.redirect;
		}
		if (routConfig.alwayShow != undefined) {
			tempData.alwayShow = routConfig.alwayShow;
		}
		if(routConfig.hideMenu){
			tempData.hideMenu = routConfig.hideMenu;
		}
		res.push(tempData);
	})

	return res;
}
