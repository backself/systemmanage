/**
 * 对应角色菜单管理模块
 */
import request from '@/utils/system/request'

/** 获取登录后可使用的权限列表 */
export function getRolePanelListApi() {
  return request({
    url: '/systemManage/correlations/roles/panel/list',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 获取登录后所有可见的链接列表 */
export function getUrlPanelListApi() {
  return request({
    url: '/systemManage/urls/all/list',
    method: 'post',
    baseURL: '/mock'
  })
}

/** 更新角色菜单关系 */
export function savePanelApi() {
  return request({
    url: '/systemManage/correlations/roles/urls/update',
    method: 'post',
    baseURL: '/mock'
  })
}