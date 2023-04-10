let rolepanel_list_data = [
	{
		"roleId":1,
		"roleName":"管理员1",
		"childs":[
			{
				"roleId":2,
				"roleName":"工作人员2",
				"childs":[
					
				],
				"urlIds":[2]
			}
		],
		"urlIds":[1,2]
	},
	{
		"roleId":3,
		"roleName":"管理员2",
		"childs":[
			{
				"roleId":4,
				"roleName":"工作人员2",
				"childs":[
					
				],
				"urlIds":[4]
			}
		],
		"urlIds":[3,4]
	}
];

let menupanel_list_data = [
	{
		urlId:'1',
		roleId:'1',
		urlName:'首页',
		urlLink:'路由路径',
		urlType:0, //链接类型,
		urlMatchType:0,
		urlCommonLevel:1,
		urlSpecLevel:1,
		childs:[
			{
				urlId:'2',
				roleId:'1',
				urlName:'链接名称',
				urlLink:'链接地址',
				urlType:1, //链接类型
				childs:[]
			},{
				urlId:'2',
				roleId:'1',
				urlName:'链接名称',
				urlLink:'链接地址',
				urlType:1, //链接类型
				childs:[]
			}
		]
		
	},
	{
		urlId:'3',
		roleId:'2',
		urlName:'菜单2',
		urlLink:'路由路径',
		urlType:0, //链接类型
		childs:[
			{
				urlId:'4',
				roleId:'2',
				urlName:'链接名称2',
				urlLink:'链接地址',
				urlType:1, //链接类型
				childs:[]
			}
		]
		
	}
];

export {rolepanel_list_data,menupanel_list_data};