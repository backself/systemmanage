let routes = [{
    path: '/pages',
    componentPath: "index",
    redirect: '/pages/products-manage',
    meta: { title: 'message.menu.page.name',  icon: 'sfont system-menu' },
    alwayShow: true,
    children: [
		{
		  path: 'products-manage',
		  componentPath: "index",
		  redirect:'/pages/productsmanage/query',
		  meta: { 
			  title: 'message.menu.page.products-manage.name', 
			  cache: false, 
			  roles: ['admin', 'editor'] 
			  },
		  alwayShow: true,
		  children:[
			  {
				path: 'query',
				componentPath: "main/products/productManage/query/index",
				meta: { title: 'message.menu.page.products-manage.query', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		},
		{
		  path: 'products-report',
		  componentPath: "index",
		  redirect:'/pages/products-report/date',
		  meta: { title: 'message.menu.page.products-report.name', cache: false, roles: ['admin', 'editor'] },
		  alwayShow: true,
		  children:[
			  {
				path: 'date',
				componentPath: "main/products/productReports/date/index",
				meta: { title: 'message.menu.page.products-report.date', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'week',
				componentPath: "main/products/productReports/week/index",
				meta: { title: 'message.menu.page.products-report.week', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'month',
				componentPath: "main/products/productReports/month/index",
				meta: { title: 'message.menu.page.products-report.month', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'year',
				componentPath: "main/products/productReports/year/index",
				meta: { title: 'message.menu.page.products-report.year', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		}
		
	]
  }
]

/**
 * 将路由树型结构数据，转换为请求传递参数与后端统一结构
 */
export function parseRouterToData(routesData:any,type:number){
	let res = [];
	let tempData = {
		urlLink:{},
		childs:[],
	};
	routesData.forEach((route)=>{
		tempData.urlLink.path = route.path;
		tempData.urlLink.meta = route.meta;
		
		if(route.children && route.children.length > 0){
			if(type == 0){
				// 一级菜单组件路径
				tempData.urlLink.componentPath = route.componentPath;
			}else {
				// 二级及其他级别组件
				tempData.urlLink.componentPath = route.componentPath;
			}
			tempData.childs = parseRouterToData(route.children,type+1);
		}else{
			tempData.urlLink.componentPath = route.componentPath;
		}
		
		if (route.redirect) {
			tempData.redirect = route.redirect;
		}
		if (route.alwayShow) {
			tempData.alwayShow = route.alwayShow;
		}
		res.push(tempData);
	})
	
	return res;
}

export function test(){
	let res = parseRouterToData(routes,0);
	console.log("转换路由信息为数据对象",res)
}