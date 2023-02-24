import request from '@/utils/system/request'

/** 登录api */
export function loginApi(data: object) {
  return request({
    url: '/user/login',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

/** 获取用户信息Api */
export function getInfoApi(data: object) {
  return request({
    url: '/user/info',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

/** 退出登录Api */
export function loginOutApi() {
  return request({
    url: '/user/out',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 修改用户信息Api */
export function passwordChange(data: object) {
  return request({
    url: '/user/update',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

/** 获取登录后需要展示的菜单 */
export function getMenuApi(data:object) {
  return request({
    url: 'auth/menu/list',
    method: 'post',
    baseURL: '/mock'
  })
}