import request from '@/utils/system/request'

export function getData(data: object) {
  return request({
    url: '/auth/user/list',
    method: 'post',
    baseURL: '/mock',
    data
  })
}
// 新增
export function add(data: object) {
  return request({
    url: '/auth/user/add',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

export function update(data: object) {
  return request({
    url: '/auth/user/update',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

export function del(data: object) {
  return request({
    url: '/auth/user/del',
    method: 'post',
    baseURL: '/mock',
    data
  })
}