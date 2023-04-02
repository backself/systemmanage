import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
  return request({
    url: '/products/query',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 新增
export function add(data: object) {
  return request({
    url: '/products/add',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 编辑
export function update(data: object) {
  return request({
    url: '/products/update',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 删除
export function del(data: object) {
  return request({
    url: '/products/del',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

