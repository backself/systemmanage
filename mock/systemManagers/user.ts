
export default [
  {
    url: '/mock/auth/user/list',
    method: 'post',
    response: ({ body }) => {
      const { page, pageSize } = body
      return {
        code: 200,
        data: {
          list: [{
			"id": 1,
			"name": "Sharon Jackson",
			"nickName": "赵丽",
			"status": 1,
			"role": 1,
			"isAdmin": 1
		},{
			"id": 2,
			"name": "Sharon Jackson",
			"nickName": "赵丽",
			"status": 1,
			"role": 1,
			"isAdmin": 1
		}
		],
          pager: {
            page: page,
            pageSize: pageSize,
            total: 1
          }
        },
        msg: ''
      };
    }
  },
  {
    url: `/mock/auth/user/add`,
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
    url: `/mock/auth/user/update`,
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
    url: `/mock/auth/user/del`,
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