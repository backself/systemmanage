/** 引入类型 */
import type { Route } from './index.type'

/** 引入路由相关的资源 */
import router, { modules } from './index'
/** 引入vuex实例 */
import store from '@/store'

/** 引入带有系统自定义name的组件，方便keep-alive实现 */
import { createNameComponent } from './createNode'
import {getMenuData} from "@/api/systemManagers/menu"

/** 引入需要权限的Modules */
import Dashboard from './modules/dashboard'
import Products from './modules/products'
import SystemManage from './modules/systemManage'


/** 登录后需要动态加入的本地路由 */
const asyncRoutes: Route[] = [
	...Dashboard,
	// ...Products,
	...SystemManage,
]

/** 
 * @name 动态路由的权限新增，供登录后调用
 * @other 如果需要进行后端接口控制菜单的话，请在此拿到后端的菜单树与asyncRoutes对比，生成一个新的值
 */
async function addRoutes() {
  // 已验证完成，下面代码添加的可以实时同步至菜单中去，可以添加setTimeout(() => {}) 模拟异步代码的操作
  // 利用前端路由表模拟后端数据问题
  return new Promise<void>((resolve) => {
	  getMenuData({}).then(function(res){
		  
		  let resoult = eachData(res.data,0);
		  console.log("首页路由配置详细：",Dashboard);
		  resoult.forEach(item =>{
			  asyncRoutes.push(item);
		  });
		  
		  asyncRoutes.forEach(item => {
		    modules.push(item)
		    router.addRoute(item)
		  })
		  resolve()
	  })
    })
}

function eachData(data: any,type:number) {

  data.forEach(d => {
	  d.path = d.path;
	  
	  if (d.children && d.children.length > 0) {
		if (type === 0) {
			// 一级菜单组件
		  d.component = createNameComponent(() => import('../layout/'+d.componentPath+'.vue'))
		} else {
			// 二级及其他级别组件
		  d.component = createNameComponent(() => import('../components/menu/'+d.componentPath+'.vue'))
		}
		eachData(d.children, type + 1)
	  } else {
		  // 叶子组件的导入
		// d.component = createNameComponent(() => import('@/views/main/products/productManage/query/index.vue'))
		d.component = createNameComponent(() => import('../views/' + d.componentPath + '.vue'))
	  }
	  
	  if(d.redirect){
		d.redirect = d.redirect;
	  }
	  d.meta = {
		  title:d.meta.title,
		  icon: d.meta.icon
	  };
	  d.alwayShow = d.alwayShow;
  })
  
  console.log("遍历结果",data)
  return data;
}



/**
 * @des 登录了之后并获取到菜单列表时会执行这个方法，实现动态路由的功能
 */
export async function getAuthRoutes() {
  // 判断token是否存在，存在则调用添加路由的方法
  if (store.state.user.token) {
   await addRoutes()
  }
}
