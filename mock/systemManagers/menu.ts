/** 给接口使用 */
const menu = [
  {
    path: '/',
    component: '@/layout/index.vue',
    redirect: '/dashboard',
    meta: { title: 'message.menu.dashboard.name', icon: 'sfont system-home' },
    children: [
      {
        path: 'dashboard',
        meta: { title: 'message.menu.dashboard.index', icon: 'sfont system-home', hideClose: true }
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