import request from '@/utils/system/request'

// 获取首页中折线图的数据
export function getDashboardBarChartData(params: object) {
  return request({
    url: '/dashboard/report/get',
    method: 'get',
    baseURL: '/mock',
    params
  })
}