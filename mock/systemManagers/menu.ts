/** 给接口使用 */
const menu = [
  {
    path: '/pages',
    componentPath: 'index',
    redirect: '/pages/products-manage',
    meta: { title: 'message.menu.page.name',  icon: 'sfont system-menu' },
    alwayShow: true,
    children: [
		{
		  path: 'products-manage',
		  componentPath: 'index',
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
				componentPath: 'main/products/productManage/query/index',
				meta: { title: 'message.menu.page.products-manage.query', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		},
		{
		  path: 'products-report',
		  componentPath: 'index',
		  redirect:'/pages/products-report/date',
		  meta: { title: 'message.menu.page.products-report.name', cache: false, roles: ['admin', 'editor'] },
		  alwayShow: true,
		  children:[
			  {
				path: 'date',
				componentPath: 'main/products/productReports/date/index',
				meta: { title: 'message.menu.page.products-report.date', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'week',
				componentPath: 'main/products/productReports/week/index',
				meta: { title: 'message.menu.page.products-report.week', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'month',
				componentPath: 'main/products/productReports/month/index',
				meta: { title: 'message.menu.page.products-report.month', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'year',
				componentPath: 'main/products/productReports/year/index',
				meta: { title: 'message.menu.page.products-report.year', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		}
		
	]
  }
]

export default [
  /** 需要展示的菜单模拟接口 */
  {
    url: `/mock/auth/menu/all/list`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menu
      }
    }
  },
  {
    url: `/mock/auth/menu/menu/list`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menu
      }
    }
  },
  {
    url: `/mock/auth/menu/add`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menu
      }
    }
  },
  {
    url: `/mock/auth/menu/update`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menu
      }
    }
  },
  {
    url: `/mock/auth/menu/del`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menu
      }
    }
  }
]