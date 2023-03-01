import request from '@/utils/system/request'

// 获取当前用户下所有可使用的菜单列表(包括链接类型)
export function getData(data: object) {
  return request({
    url: '/auth/menu/all/list',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 获取当前用户下所有可使用的菜单列表(不包括链接类型)
export function getMenuData(data: object) {
  return request({
    url: 'auth/menu/menu/list',
    method: 'post',
    baseURL: '/mock',
    data
  })
}
