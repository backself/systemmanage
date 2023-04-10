import request from '@/utils/system/request'

// 获取当前用户下所有可使用的菜单列表(包括链接类型)
export function getLinkListData(data: object) {
  return request({
    url: '/urls/all/list',
    method: 'post',
    data
  })
}

// 获取当前用户下所有可使用的菜单列表(不包括链接类型)
export function getMenuData(data: object) {
  return request({
    url: '/urls/nav/list',
    method: 'post',
    data
  })
}

// 新增
export function add(data: object) {
  return request({
    url: '/urls/add',
    method: 'post',
    data
  })
}

// 编辑
export function update(data: object) {
  return request({
    url: '/urls/update',
    method: 'post',
    data
  })
}

// 删除
export function del(data: object) {
  return request({
    url: '/urls/del',
    method: 'post',
    data
  })
}

