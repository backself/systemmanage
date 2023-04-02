import {menuRoute} from "./modules/menu"
import {menupanel_list_data} from "./modules/role_menu_panel"

export default [
	/** 需要展示的菜单模拟接口 */
	{
		url: `/mock/systemManage/urls/all/list`,
		method: 'post',
		response: ({ body }) => {
			return {
				code: 200,
				data: menupanel_list_data
			}
		}
	},
	{
		url: `/mock/systemManage/urls/nav/list`,
		method: 'post',
		response: ({ body }) => {
			return {
				code: 200,
				data: menuRoute
			}
		}
	},
	{
		url: `/mock/systemManage/urls/add`,
		method: 'post',
		response: ({ body }) => {
			return {
				code: 200,
				data: "",
				msg:""
			}
		}
	},
	{
		url: `/mock/systemManage/urls/update`,
		method: 'post',
		response: ({ body }) => {
			return {
				code: 200,
				data: "",
				msg:""
			}
		}
	},
	{
		url: `/mock/systemManage/urls/del`,
		method: 'post',
		response: ({ body }) => {
			return {
				code: 200,
				data: "",
				msg:""
			}
		}
	}
]