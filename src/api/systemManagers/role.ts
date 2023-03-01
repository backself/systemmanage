/**
 * 对应角色管理模块
 */
import request from '@/utils/system/request'

/** 获取登录后可使用的权限列表 */
export function getRolePanelListApi() {
  return request({
    url: '/systemManage/role/rolepanel/list',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 获取登录后所有可见的链接列表 */
export function getMenuPanelListApi() {
  return request({
    url: '/systemManage/role/menupanel/list',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 获取登录后所有可见的链接列表 */
export function savePanelListApi() {
  return request({
    url: 'systemManage/role/save',
    method: 'post',
    baseURL: '/mock'
  })
}