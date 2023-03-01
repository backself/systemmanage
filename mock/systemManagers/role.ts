
const rolepanel_list_data = [
	{
		authId:'1',
		authName:'角色名称authId1',
		authStatus:0,
		childs:[
			{
				authId:'2',
				authName:'角色名称authId2',
				authStatus:0,
				childs:[
					
				],
				authType:1,
				authLevel:1,//级别权限
				authMatchType:0,//匹配类型
				urlList:["2"]
			}
		],
		authType:1,
		authLevel:1,//级别权限
		authMatchType:0,//匹配类型
		urlList:["1"]
	},
	{
		authId:'3',
		authName:'角色名称authId3',
		authStatus:0,
		childs:[
			{
				authId:'4',
				authName:'角色名称authId4',
				authStatus:0,
				childs:[
					
				],
				authType:1,
				authLevel:1,//级别权限
				authMatchType:0,//匹配类型
				urlList:["4"]
			}
		],
		authType:1,
		authLevel:1,//级别权限
		authMatchType:0,//匹配类型
		urlList:["3"],
	}
];

const menupanel_list_data = [
	{
		urlId:'1',
		authId:'1',
		urlName:'链接名称urlId=1,authId=2',
		urlLink:'链接具体地址',
		urlStatus:0,
		childs:[
			{
				urlId:'2',
				authId:'2',
				urlName:'链接名称urlId=2,authId=2',
				urlLink:'链接具体地址',
				urlStatus:0,
				childs:[
					{
						urlId:'6',
						authId:'6',
						urlName:'链接名称urlId=6,authId=2',
						urlLink:'链接具体地址',
						urlStatus:0,
						childs:[],
						urlType:1,
						urlLevel:1,//级别权限
						urlMatchType:0,//匹配类型
				}],
				urlType:1,
				urlLevel:1,//级别权限
				urlMatchType:0,//匹配类型
			},
			{
				urlId:'5',
				authId:'5',
				urlName:'链接名称urlId=5,authId=2',
				urlLink:'链接具体地址',
				urlStatus:0,
				childs:[],
				urlType:1,
				urlLevel:1,//级别权限
				urlMatchType:0,//匹配类型
			}
		],
		urlType:1,
		urlLevel:1,//级别权限
		urlMatchType:0,//匹配类型
	},
	{
		urlId:'3',
		authId:'3',
		urlName:'链接名称urlId=3,authId=2',
		urlLink:'链接具体地址',
		urlStatus:0,
		childs:[
			{
				urlId:'4',
				authId:'4',
				urlName:'链接名称urlId=4,authId=2',
				urlLink:'链接具体地址',
				urlStatus:0,
				childs:[],
				urlType:1,
				urlLevel:1,//级别权限
				urlMatchType:0,//匹配类型
			}
		],
		urlType:1,
		urlLevel:1,//级别权限
		urlMatchType:0,//匹配类型
	}
];

export default [
	/**
	 * 角色面板对应请求
	 */
	{
	  url: `/mock/systemManage/role/rolepanel/list`,
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
    url: `/mock/systemManage/role/menupanel/list`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: menupanel_list_data,
        msg: ''
      };
    }
  },
  /**
  	 * 菜单面板对应请求
  	 */
  {
    url: `/mock/systemManage/role/save`,
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
