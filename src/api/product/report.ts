import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
  return request({
    url: '/product/report/get',
    method: 'post',
    baseURL: '/mock',
    data
  })
}
