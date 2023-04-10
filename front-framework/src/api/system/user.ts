import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
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

// 编辑
export function update(data: object) {
  return request({
    url: '/users/update',
    method: 'post',
    data
  })
}

// 状态变更
export function updateStatus(data: object) {
  return request({
    url: '/users/updateStatus',
    method: 'post',
    data
  })
}

// 删除
export function del(data: object) {
  return request({
    url: '/users/del',
    method: 'post',
    data
  })
}