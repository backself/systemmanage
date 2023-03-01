import request from '@/utils/system/request'

// 获取首页中折线图的数据
export function getData(params: object) {
  return request({
    url: '/dashboard/bar_chart/list',
    method: 'post',
    baseURL: '/mock',
    params
  })
}