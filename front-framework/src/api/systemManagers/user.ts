import request from '@/utils/system/request'

export function getUserListData(data: object) {
  return request({
    url: '/users/list',
    method: 'post',
    data
  })
}
// 新增
export function add(data: object) {
  return request({
    url: '/users/add',
    method: 'post',
    data
  })
}

export function update(data: object) {
  return request({
    url: '/users/update',
    method: 'post',
    data
  })
}

export function del(data: object) {
  return request({
    url: '/users/del',
    method: 'post',
    data
  })
}