/**
 * 对应角色管理模块
 */
import request from '@/utils/system/request'

/** 获取登录后所有的权限链接列表 */
export function getRolePanelListApi() {
  return request({
    url: '/systemManage/role/rolepanel/list',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 获取登录后所有的可使用的链接列表 */
export function getMenuPanelListApi() {
  return request({
    url: '/systemManage/role/menupanel/list',
    method: 'post',
    baseURL: '/mock'
  })
}