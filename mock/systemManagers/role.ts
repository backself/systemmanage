import {menupanel_list_data,rolepanel_list_data} from "./modules/role_menu_panel"

export default [
	/**
	 * 角色面板对应请求
	 */
	{
	  url: `/mock/roles/panel/list`,
	  method: 'post',
	  response: ({ body }) => {
	    return {
	      code: 200,
	      data: rolepanel_list_data,
	      msg: ''
	    };
	  }
	},

   /**
	* 菜单面板对应请求
	*/
  {
    url: `/mock/roles/correlations/urls/update`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
]
