export default {
  menu: {
    dashboard: {
      name: 'dashboard',
      index: '首页'
    },
    system: {
      name: '系统目录',
      redirect: '重定向页面',
      '404': '404',
      '401': '401',
	  'execption':'未匹配到链接并重定向'
    },
    page: {
      name: '产品数据',
	  'products-manage': {
		  name:'产品管理',
		  query:'产品查询',
	  },
	  'products-report':{
		 name:'产品报表',
		  "date":'日报',
		  "week":'周报',
		  "month":'月报',
		  "year":'年报',
	  }
    }, 
    systemManage: {
      name: '系统管理',
      menu: '菜单管理',
      role: '角色菜单关系管理',
      user: '用户管理'
    }
  }
}