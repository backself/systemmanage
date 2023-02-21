import type { Route } from '../index.type'
import Layout from '@/layout/index.vue'
import { createNameComponent } from '../createNode'
import MenuBox from '@/components/menu/index.vue'
const route: Route[] = [
  {
    path: '/pages',
    component: Layout,
    redirect: '/pages/products-manage',
    meta: { title: 'message.menu.page.name',  icon: 'sfont system-menu' },
    alwayShow: true,
    children: [
		{
		  path: 'products-manage',
		  component: createNameComponent(() => import('@/components/menu/index.vue')),
		  redirect:'/pages/productsmanage/query',
		  meta: { title: 'message.menu.page.products-manage.name', cache: false, roles: ['admin', 'editor'] },
		  alwayShow: true,
		  children:[
			  {
				path: 'query',
				component: createNameComponent(() => import('@/views/main/products/productManage/query/index.vue')),
				meta: { title: 'message.menu.page.products-manage.query', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		},
		{
		  path: 'products-report',
		  component: createNameComponent(() => import('@/components/menu/index.vue')),
		  redirect:'/pages/products-report/date',
		  meta: { title: 'message.menu.page.products-report.name', cache: false, roles: ['admin', 'editor'] },
		  alwayShow: true,
		  children:[
			  {
				path: 'date',
				component: createNameComponent(() => import('@/views/main/products/productReports/date/index.vue')),
				meta: { title: 'message.menu.page.products-report.date', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'week',
				component: createNameComponent(() => import('@/views/main/products/productReports/week/index.vue')),
				meta: { title: 'message.menu.page.products-report.week', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'month',
				component: createNameComponent(() => import('@/views/main/products/productReports/month/index.vue')),
				meta: { title: 'message.menu.page.products-report.month', cache: false, roles: ['admin', 'editor'] }, 
			  },
			  {
				path: 'year',
				component: createNameComponent(() => import('@/views/main/products/productReports/year/index.vue')),
				meta: { title: 'message.menu.page.products-report.year', cache: false, roles: ['admin', 'editor'] }, 
			  },
		  ]
		}
		
	]
  }
]

export default route