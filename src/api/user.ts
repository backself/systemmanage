import request from '@/utils/system/request'

/** 登录api */
export function loginApi(data: object) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

/** 获取用户信息Api */
export function getInfoApi(data: object) {
  return request({
    url: '/users/info',
    method: 'post',
    data
  })
}

/** 退出登录Api */
export function loginOutApi() {
  return request({
    url: '/user/out',
    method: 'post',
  })
}

/** 修改用户信息Api */
export function passwordChange(data: object) {
  return request({
    url: '/users/update',
    method: 'post',
    data
  })
}
