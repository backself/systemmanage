/** 给接口使用 */

/**
 * 菜单路由信息 用于获取菜单导航栏
 */
const menuRoute = [
	{
		urlLink: {
			path: '/pages',
			componentPath: 'index',
			redirect: '/pages/products-manage',
			meta: {
				title: 'message.menu.page.name', icon: 'sfont system-menu'
			},
			alwayShow: true,
		},
		childs: [
			{
				urlId:2,
				urlName:'message.menu.page.products-manage.name',
				urlType:0,
				urlLink: {
					path: 'products-manage',
					componentPath: 'index',
					redirect: '/pages/productsmanage/query',
					meta: {
						title: 'message.menu.page.products-manage.name',
						cache: false,
						roles: ['admin', 'editor'
						]
					},
					alwayShow: true,
				},
				childs: [
					{
						urlId:3,
						urlName:'message.menu.page.products-manage.query',
						urlType:0,
						urlLink: {
							path: 'query',
							componentPath: 'main/products/productManage/query/index',
							meta: {
								title: 'message.menu.page.products-manage.query', cache: false, roles: ['admin', 'editor'
								]
							},
						},
						childs: []
					},
				]
			},
			{
				urlId:4,
				urlName:'message.menu.page.products-report.name',
				urlType:0,
				urlLink: {
					path: 'products-report',
					componentPath: 'index',
					redirect: '/pages/products-report/date',
					meta: {
						title: 'message.menu.page.products-report.name', cache: false, roles: ['admin', 'editor'
						]
					},
					alwayShow: true,
				},
				childs: [
					{
						urlId:5,
						urlName:'message.menu.page.products-report.date',
						urlType:0,
						urlLink: {
							path: 'date',
							componentPath: 'main/products/productReports/date/index',
							meta: {
								title: 'message.menu.page.products-report.date', cache: false, roles: ['admin', 'editor'
								]
							},
						}, childs: []
					},
					{
						urlId:6,
						urlName:'message.menu.page.products-report.week',
						urlType:0,
						urlLink: {
							path: 'week',
							componentPath: 'main/products/productReports/week/index',
							meta: {
								title: 'message.menu.page.products-report.week', cache: false, roles: ['admin', 'editor'
								]
							},
						}, childs: []
					},
					{
						urlId:7,
						urlName:'message.menu.page.products-report.month',
						urlType:0,
						urlLink: {
							path: 'month',
							componentPath: 'main/products/productReports/month/index',
							meta: {
								title: 'message.menu.page.products-report.month', cache: false, roles: ['admin', 'editor'
								]
							},
						}, childs: []
					},
					{
						urlId:8,
						urlName:'message.menu.page.products-report.year',
						urlType:0,
						urlLink: {
							path: 'year',
							componentPath: 'main/products/productReports/year/index',
							meta: {
								title: 'message.menu.page.products-report.year', cache: false, roles: ['admin', 'editor'
								]
							},
						}, childs: []
					},
				]
			}
		]
	}
]

export {menuRoute};