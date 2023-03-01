import request from '@/utils/system/request'

// 获取首页中在线数据
export function getOnlineData(params: object) {
  return request({
    url: '/dashboard/online/list',
    method: 'post',
    baseURL: '/mock',
    params
  })
}
