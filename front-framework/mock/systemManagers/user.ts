
export default [
  {
    url: '/mock/users/list',
    method: 'post',
    response: ({ body }) => {
      const { pageIndex, pageSize,totalPage } = body
      return {
        code: 200,
        data: {
          list: [{
			"userId": 1,
			"userName": "Sharon Jackson",
			"nickName": "赵丽",
			"userStatus": 1,
			"roleId":1,
			"roleName": "工作人员",
			"parentUserId":0,
			"userPassword":"123456"
		},{
			"userId": 2,
			"userName": "Sharon Jackson",
			"nickName": "赵丽",
			"userStatus": 1,
			"roleId":1,
			"roleName": "工作人员",
			"parentUserId":0,
			"userPassword":"123456"
		}
		],
		pageIndex: pageIndex,
		pageSize: pageSize,
		totalPage:totalPage,
		total: 2
        },
        msg: ''
      };
    }
  },
  {
    url: `/mock/users/add`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
  {
    url: `/mock/users/update`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
  {
    url: `/mock/users/del`,
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