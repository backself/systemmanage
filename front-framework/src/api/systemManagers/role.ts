/**
 * 对应角色菜单管理模块
 */
import request from '@/utils/system/request'

/** 获取登录后可使用的权限列表 */
export function getRolePanelListApi() {
  return request({
    url: '/roles/panel/list',
    method: 'post',
  })
}

/** 获取登录后所有可见的链接列表 */
export function getUrlPanelListApi() {
  return request({
    url: '/urls/all/list',
    method: 'post',
  })
}

/** 更新角色菜单关系 */
export function savePanelApi() {
  return request({
    url: '/roles/correlations/urls/update',
    method: 'post',
  })
}