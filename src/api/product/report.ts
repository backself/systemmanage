import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
  return request({
    url: '/reports/get',
    method: 'post',
    data
  })
}
