/** 引入类型 */
import type { Route } from './index.type'

/** 引入路由相关的资源 */
import router, { modules } from './index'
/** 引入vuex实例 */
import store from '@/store'

/** 引入带有系统自定义name的组件，方便keep-alive实现 */
import {getMenuData} from "@/api/systemManagers/menu"

/** 引入需要权限的Modules */
import Dashboard from './modules/dashboard'
import Products from './modules/products'
import SystemManage from './modules/systemManage'
import {parseDataToRouter} from "./parseToRouterUtil"

/** 登录后需要动态加入的本地路由 */
const asyncRoutes: Route[] = [
	// ...Dashboard,
	// ...Products,
	// ...SystemManage,
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
		  // console.log(res)
		  let data_temp = JSON.parse(JSON.stringify(res.data));
		  let resoult = parseDataToRouter(res.data,0);
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

/**
 * @des 登录了之后并获取到菜单列表时会执行这个方法，实现动态路由的功能
 */
export async function getAuthRoutes() {
  // 判断token是否存在，存在则调用添加路由的方法
  if (store.state.user.token) {
   await addRoutes()
  }
}
